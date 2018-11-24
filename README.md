# Android-
自定义索引，使用场景 ，如电话联系人等等展示，使用注意里边有jar包，使用之前一定要导入
难点

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
