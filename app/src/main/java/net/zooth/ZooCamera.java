package net.zooth;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.text.method.Touch;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class ZooCamera extends Activity implements View.OnClickListener{

    private Button btnTakePhoto, cam, sav;
    TouchImageView imgTakenPhoto, f;
    private static final int CAM_REQUEST = 1313;

    private static final int TAKE_PICTURE = 1;
    private Uri imageUri;
    public boolean saveboo=false;
    public Bitmap bittt=null;
    public Drawable myDrawable=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_zoo_camera);
        //btnTakePhoto = (Button) findViewById(R.id.button);//
        //imgTakenPhoto = (ImageView) findViewById(R.id.imageview);
        //btnTakePhoto.setOnClickListener(new btnTakePhotoClicker());*/

        /*Intent cameraintent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraintent, CAM_REQUEST);*/

        //File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");//HTC/Internal Storage/Pic..jpg

        //SAVING MECHANISM to save move to call up camera
        /*String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/ZooTH_Photos/My Photos");
        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-"+ n +".jpg";
        File photo = new File (myDir, fname);//***
        if (photo.exists ()) photo.delete ();*/

        callUpCamera();
    }

    public void callUpCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photo = new File(Environment.getExternalStorageDirectory() + "/ZooTH/temp/.nomedia",  "temp.jpg");//HTC/Internal Storage/Pic..jpg /.nomedia
        intent.putExtra(MediaStore.EXTRA_OUTPUT,//SAVE***
                Uri.fromFile(photo));
        imageUri = Uri.fromFile(photo);
        startActivityForResult(intent, TAKE_PICTURE);
    }

    public Bitmap overlayFrame(Bitmap bmp1, Bitmap bmp2) {
        Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(), bmp1.getConfig());
        Canvas canvas = new Canvas(bmOverlay);

        canvas.drawBitmap(bmp1, new Matrix(), null);
        Rect fittoframe = new Rect(0,0,bmp1.getWidth(),bmp1.getHeight());
        canvas.drawBitmap(bmp2, null, fittoframe, null);//Stretch frame to completely cover bmp1
        return bmOverlay;
    }

    public void saveBit(Bitmap bitmp){
        {//IF save button is clicked, save the bitmp
            File myDir = new File(Environment.getExternalStorageDirectory() + "/ZooTH/ZooTH Photos");
            myDir.mkdirs();
            Random generator = new Random();
            int n = 10000;
            n = generator.nextInt(n);
            String fname = "Image-" + n + ".jpg";
            File fil = new File(myDir, fname);
            //getContentResolver().notifyChange(Uri.fromFile(fil), null);
            if (fil.exists()) fil.delete();
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(fil);
                bitmp.compress(Bitmap.CompressFormat.JPEG, 90, out); // bmp is your Bitmap instance
                // PNG is a lossless format, the compression factor (100) is ignored
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            MediaScannerConnection.scanFile(this, new String[]{fil.getPath()}, new String[]{"image/jpeg"}, null);//shows up in gallery
        }
    }

    public static int getCameraPhotoOrientation(Context context, Uri imageUri, String imagePath){
        int rotate = 0;
        try {
            context.getContentResolver().notifyChange(imageUri, null);
            File imageFile = new File(imagePath);
            ExifInterface exif = new ExifInterface(
                    imageFile.getAbsolutePath());
            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;
            }


           // Log.v(TAG, "Exif orientation: " + orientation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rotate;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);//data is taken photo
        /*if(requestCode == CAM_REQUEST && resultCode == RESULT_OK)
        {
            setContentView(R.layout.activity_zoo_camera);
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            imgTakenPhoto = (ImageView) findViewById(R.id.takenphotopreview);
            imgTakenPhoto.setImageBitmap(thumbnail);


        } else {
            Toast.makeText(getApplicationContext(), "Photo not taken!", Toast.LENGTH_LONG).show();
        }}*/


        switch (requestCode) {
            case TAKE_PICTURE:
                if (resultCode == RESULT_OK) {
                    setContentView(R.layout.activity_zoo_camera);
                    Uri selectedImage = imageUri;
                    getContentResolver().notifyChange(selectedImage, null);

                    imgTakenPhoto = (TouchImageView) findViewById(R.id.takenphotopreview);
                    imgTakenPhoto.setMaxZoom(5);

                    ContentResolver cr = getContentResolver();
                    Bitmap bitmap;
                    try {
                        bitmap = android.provider.MediaStore.Images.Media.getBitmap(cr, selectedImage);

                        String filePath = selectedImage.getPath();


                        //***TEMPORARY PORTRAIT/LANDSCAPE FRAME SWITCH*** issue with EXIF
                        int rotary = getCameraPhotoOrientation(this, selectedImage, selectedImage.getPath());
                        switch(rotary){
                            case(0):
                                myDrawable = getResources().getDrawable(R.drawable.dice);//Always read EXIF as zero?? **PORTRAIT**
                                break;
                            /*case(-1):
                                myDrawable = getResources().getDrawable(R.drawable.nsx);//**LANDSCAPE**
                                break;*/
                        }


                        Bitmap frame = ((BitmapDrawable) myDrawable).getBitmap();

                        bittt = overlayFrame(bitmap, frame);//Combine taken photo with preset frame

                        sav = (Button) findViewById(R.id.save);
                        sav.setOnClickListener(this);
                        cam = (Button) findViewById(R.id.camera);
                        cam.setOnClickListener(this);

                        imgTakenPhoto.setImageBitmap(bittt);//Show temp.jpg taken photo here!
                        //Toast.makeText(this, selectedImage.toString(),Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        Toast.makeText(this, "Failed to load.", Toast.LENGTH_SHORT).show();
                        Log.e("Camera", e.toString());
                    }
                    break;

                }
            default:
                Toast.makeText(getApplicationContext(), "No photo taken! Press Back.", Toast.LENGTH_SHORT).show();
                break;
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                saveBit(bittt);
                Toast.makeText(this, "Saved.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.camera:
                Intent intent = new Intent(this, ZooCamera.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
    }
}}
