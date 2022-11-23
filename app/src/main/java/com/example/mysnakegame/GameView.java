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

    /**
     * Картинки травы
     */
    private Bitmap bmGrass1, bmGrass2;

    /**
     * Картинка яблока
     */
    private Bitmap bmApple;

    /**
     * Картинка змейки
     */
    private Bitmap bmSnake;

    /**
     * Размер элемента на нашем дисплее
     */
    public static int sizeElementMap = 75 * Constants.SCREEN_WIDTH / 1080;

    /**
     * Наш массив ячеек из травы
     */
    private final ArrayList<Grass> arrGrass = new ArrayList<>();

    /**
     * Размер поля (ширина и высота)
     */
    private int w = 12, h = 21;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bmGrass1 = BitmapFactory.decodeResource(getResources(), R.drawable.grass01);
        bmGrass1 = Bitmap.createScaledBitmap(bmGrass1, sizeElementMap, sizeElementMap, true);
        bmGrass2 = BitmapFactory.decodeResource(getResources(), R.drawable.grass02);
        bmGrass2 = Bitmap.createScaledBitmap(bmGrass2, sizeElementMap, sizeElementMap, true);
        bmSnake = BitmapFactory.decodeResource(getResources(), R.drawable.snake);
        bmSnake = Bitmap.createScaledBitmap(bmSnake, 14 * sizeElementMap, sizeElementMap, true);
        bmApple = BitmapFactory.decodeResource(getResources(), R.drawable.apple);
        bmApple = Bitmap.createScaledBitmap(bmApple, sizeElementMap, sizeElementMap, true);

        // Создаем массив из травы в шахматном порядке
        for(int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                if((j + i) % 2 == 0){
                    arrGrass.add(new Grass(bmGrass1, j * bmGrass1.getWidth() + Constants.SCREEN_WIDTH / 2 - (w / 2) * bmGrass1.getWidth(),
                            i * bmGrass1.getHeight() + 50 * Constants.SCREEN_HEIGHT / 1920, bmGrass1.getWidth(), bmGrass1.getHeight()));
                }else{
                    arrGrass.add(new Grass(bmGrass2, j * bmGrass2.getWidth() + Constants.SCREEN_WIDTH / 2 - (w / 2) * bmGrass2.getWidth(),
                            i * bmGrass2.getHeight() + 50 * Constants.SCREEN_HEIGHT / 1920, bmGrass2.getWidth(), bmGrass2.getHeight()));
                }
            }
        }
    }

    public void draw(Canvas canvas){
        super.draw(canvas);

        // Добавим фон
        canvas.drawColor(0xFF065700);

        // Добавим наше поле из травы
        for(int i = 0; i < arrGrass.size(); i++){
            canvas.drawBitmap(arrGrass.get(i).getBm(), arrGrass.get(i).getX(), arrGrass.get(i).getY(), null);
        }
    }
}
