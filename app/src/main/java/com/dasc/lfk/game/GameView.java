package com.dasc.lfk.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

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

    /**
     * Crea la vista e inicializa el contexto
     * @param context Es el contexto de la aplicación android
     */
    public GameView(Context context) {
        super(context);
        paint = new Paint();
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
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        canvas.drawLine(0, 0, 100, 800, paint);
    }

}
