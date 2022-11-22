package com.example.mysnakegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GameView extends View {

    private Bitmap bmGrass1, bmGrass2, bmSnake1, bmApple;
    private ArrayList<Grass> arrGrass = new ArrayList<>();
    private int w = 12, h=21;
    public static int sizeElementMap = 75*Constants.SCREEN_WIDTH/1080;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bmGrass1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.grass);
        bmGrass1 = Bitmap.createScaledBitmap(bmGrass1, sizeElementMap, sizeElementMap, true);
        bmGrass2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.grass03);
        bmGrass2 = Bitmap.createScaledBitmap(bmGrass2, sizeElementMap, sizeElementMap, true);
        bmSnake1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.snake1);
        bmSnake1 = Bitmap.createScaledBitmap(bmSnake1, 14*sizeElementMap, sizeElementMap, true);
        bmApple = BitmapFactory.decodeResource(this.getResources(), R.drawable.apple);
        bmApple = Bitmap.createScaledBitmap(bmApple, sizeElementMap, sizeElementMap, true);
        for(int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                if((j+i)%2==0){
                    arrGrass.add(new Grass(bmGrass1, j*bmGrass1.getWidth() + Constants.SCREEN_WIDTH/2 - (w/2)*bmGrass1.getWidth(), i*bmGrass1.getHeight()+50*Constants.SCREEN_HEIGHT/1920, bmGrass1.getWidth(), bmGrass1.getHeight()));
                }else{
                    arrGrass.add(new Grass(bmGrass2, j*bmGrass2.getWidth() + Constants.SCREEN_WIDTH/2 - (w/2)*bmGrass2.getWidth(), i*bmGrass2.getHeight()+50*Constants.SCREEN_HEIGHT/1920, bmGrass2.getWidth(), bmGrass2.getHeight()));
                }
            }
        }
    }

    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawColor(0xFF065700);
        for(int i = 0; i < arrGrass.size(); i++){
            canvas.drawBitmap(arrGrass.get(i).getBm(), arrGrass.get(i).getX(), arrGrass.get(i).getY(), null);
        }
    }
}
