package com.example.lianxiren;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.provider.UserDictionary;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**1创建字母
 * 2定义每条的宽高
 * 3测量
 * 4将么一个字母画进去
 * 5重写onTocu方法
 * 6
 *
 */

public class Lian  extends View {
    //定义数组
    private String[] words={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" };
    private  Paint paint;
   private int width=0;
   private int height=0;
    private int Index=0;

    public Lian(Context context) {
        this(context,null);

    }

    public Lian(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
        //创建画笔
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextSize(50);

    }

    public Lian(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                 width=getMeasuredWidth();
                 height=getMeasuredHeight()/words.length;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
          for(int i=0;i<words.length;i++){
                    if(Index==i){
                     paint.setColor(Color.GRAY);
                       // Index=i;
                    }else{
                        paint.setColor(Color.GREEN);
                    }
                     //得到单词
                     String word=words[i];
                      Rect ref=new Rect();
                      //0-1表示取矩形里边的一个字母
                      paint.getTextBounds(word,0,1,ref);
                      //获取字母的宽高
                    float  wordsW=ref.height();
                      float wordY=ref.width();

                      //计算每个字母的坐标
                    float  word_x=width/2-wordsW/2;
                  float word_Y=height/2+wordY/2+i*height;
                    //画
                 canvas.drawText(word,word_x,word_Y,paint);

          }
    }
    //重写方法

    @Override
    public boolean onTouchEvent(MotionEvent event) {
           super.onTouchEvent(event);
          switch (event.getAction()){
              case MotionEvent.ACTION_DOWN:
                  break;
              case MotionEvent.ACTION_MOVE:
                  float Y= event.getY();
                  //数字的索引
                  int text_index=(int)(Y/height);
                  if(Index!=text_index){
                      Index=text_index;
                      invalidate();
                      if(onLisner!=null&&Index<=words.length){
                          onLisner.changeWord(words[Index]);
                      }
                  }

                  break;
              case MotionEvent.ACTION_UP:
                  Index=-1;
                  invalidate();
                  break;
          }

        return true;
    }
    //创建接口传递数据
    public interface OnLisner{
        //创建传递数据的方法
        void changeWord(String Words);
    }

    public void setOnLisner(OnLisner onLisner) {
        this.onLisner = onLisner;
    }

    //创建成员变量
    private OnLisner onLisner;
    //设置

}
