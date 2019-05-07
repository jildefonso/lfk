package com.dasc.lfk.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.dasc.lfk.R;

/**
 * Es la vista principal del juego, donde se dibujrá todo
 * lo necesario en la pantalla.
 */
public class GameView extends SurfaceView
{

    /**
     * Herramienta de pintado
     */
    private Paint paint;

    private Bitmap pingu;

    /**
     * Crea la vista e inicializa el contexto
     * @param context Es el contexto de la aplicación android
     */
    public GameView(Context context) {
        super(context);
        paint = new Paint();
        pingu = BitmapFactory.decodeResource(getResources(), R.drawable.pingu);
        getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Canvas canvas = getHolder().lockCanvas();
                onDraw(canvas);
                getHolder().unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }

    /**
     * Dibuja en la vista
     * @param canvas Lienzo en el que se dibuja
     */
    @Override
    protected void onDraw(Canvas canvas) {
        drawBackground(canvas);
        drawScenario(canvas);
        drawPlayer(canvas);
    }

    private void drawBackground(Canvas canvas) {
        paint.setColor(getResources()
                .getColor(R.color.background, getContext().getTheme()));
        canvas.drawRect(getLeft(), getTop(), getRight(), getBottom(), paint);
    }

    private int getOffsetX() {
        int width = 1000 - 20;
        int midX = (getRight() - getLeft()) / 2;
        return midX - (width / 2);
    }

    private int getOffsetY() {
        int height = 1000 - 20;
        int midY = (getBottom() - getTop()) / 2;
        return midY - (height / 2);

    }

    private void drawScenario(Canvas canvas) {
        paint.setColor(getResources()
                .getColor(R.color.scenario_dot, getContext().getTheme()));

        int offsetX = getOffsetX();
        int offsetY = getOffsetY();


        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                canvas.drawOval(row * 100 + offsetX,
                        col * 100 + offsetY,
                        row * 100 + 80 + offsetX,
                        col * 100 + 80 + offsetY, paint);
            }
        }
    }

    private void drawPlayer(Canvas canvas) {
        int mx = 7;
        int my = 4;

        int offsetX = getOffsetX();
        int offsetY = getOffsetY();

        offsetX += mx * 100;
        offsetY += my * 100;

        Rect source = new Rect(0, 0, pingu.getWidth(), pingu.getHeight());
        Rect target = new Rect(offsetX,
                offsetY,
                offsetX + 100 - 10,
                offsetY + 100 - 10);
        canvas.drawBitmap(pingu, source, target, paint);
    }

}
