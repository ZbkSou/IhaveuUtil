package com.ihaveu.bc.widget;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ihaveu.bc.R;
import com.ihaveu.bc.utils.TextUtil;

/**
 * Created by bc on 16/10/12.
 * Describe
 */
public class DTextView extends TextView{
  public DTextView(Context context){
    super(context);
  }
  public DTextView(Context context, AttributeSet attrs){
    super(context,attrs);

    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DTextView);
    int type = typedArray.getInt(R.styleable.DTextView_DTextView_font,0);
    setTypeface(type);
    typedArray.recycle();
  }
  public DTextView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, 0);
  }
  @Override
  public void setText(CharSequence text, BufferType type) {
    SpannableStringBuilder s = fixRMB(text + "");
    if (s != null) super.setText(s, type);
    else super.setText(text, type);
  }
  /**
   * 设置字体
   *
   * @param type
   */
  public void setTypeface(int type) {
    TextUtil.setFont(this, type);
  }
  /**
   * 处理rmb显示问题
   * @param text
   * @return
   */
  private SpannableStringBuilder fixRMB(String text) {
    if (text == null) {
      return null;
    }
    Typeface enFont = TextUtil.getTypeFaceMap().get(TextUtil.FONT_EN_2);
    SpannableStringBuilder ss = new SpannableStringBuilder(text);
    if (text.indexOf("¥") >=0) {
      text = text.replace("¥", "￥");
    }
    int rmbIndex = text.indexOf("￥");
    if (rmbIndex < 0) {
      return null;
    }
    ss.setSpan(new CustomTypefaceSpan("", enFont), rmbIndex, rmbIndex + 1, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
    return ss;
  }


  /**
   * 设置银行卡样式
   */
  public void setBankCardStyle() {
    StringBuffer text = new StringBuffer(this.getText());
    if (text.length() > 12) {
      text = text.insert(4, " ");
      text = text.insert(9, " ");
      text = text.insert(14, " ");
      if (text.length() > 19) {
        text = text.insert(19, " ");
      }
    }
    this.setText(text);
  }


}
