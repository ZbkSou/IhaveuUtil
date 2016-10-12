package com.ihaveu.bc.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.ihaveu.bc.R;
import com.ihaveu.bc.utils.AsteriskPasswordTransformationMethod;
import com.ihaveu.bc.utils.MeasureUtil;
import com.ihaveu.bc.utils.TextUtil;

/**
 * Created by bc on 16/10/12.
 * Describe
 */
public class DEditText extends RelativeLayout{

  private String[] mEmailSufixs = new String[]{"qq.com", "163.com", "126.com", "gmail.com", "sina.com", "hotmail.com",
      "yahoo.cn", "sohu.com", "foxmail.com", "139.com", "yeah.net", "vip.qq.com", "vip.sina.com"};
  private Context mContext;
  private ImageButton mDeleteButton;
  private EditText mEditText;
  private GridView mGridView;
  private PopupWindow mPopupWindow;
  private boolean mNotNull = false;
  private String mNotNullAlert = "";
  private Drawable mDrawable;
  private boolean isEmail;
  private boolean isBankCard;
  private boolean isPhone;
  public DEditText(Context context) {
    super(context);
  }

  public DEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    mDrawable = getResources().getDrawable(R.drawable.no_voucher_hint);
    mDrawable.setBounds(MeasureUtil.dip2px(2), MeasureUtil.dip2px(1), MeasureUtil.dip2px(31), MeasureUtil.dip2px(23));
    LayoutInflater.from(context).inflate(R.layout.d_edit_text,this);
    TypedArray ta  = context.obtainStyledAttributes(attrs,R.styleable.d_edittext);
    mDeleteButton =  (ImageButton) findViewById(R.id.d_delete_button);
    mEditText = (EditText) findViewById(R.id.d_edit_text);
    View v = LayoutInflater.from(context).inflate(R.layout.login_auto_complete_gridview, null);
    mGridView = (GridView) v.findViewById(R.id.d_grid_email);
    mPopupWindow = new PopupWindow(v, LayoutParams.MATCH_PARENT, MeasureUtil.dip2px(100), false);
    // 这三行代码的作用是点击空白处的时候PopupWindow会消失
    mPopupWindow.setTouchable(true);
    mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

      @Override
      public void onDismiss() {

      }
    });
    mPopupWindow.setOutsideTouchable(true);
    mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
    mEditText.setHint(ta.getResourceId(R.styleable.d_edittext_d_hint, R.string.empty));
    int maxLength = ta.getInt(R.styleable.d_edittext_maxLength, 0);
    final int maxLine = ta.getInt(R.styleable.d_edittext_d_maxLine, 1);
    boolean isPassword = ta.getBoolean(R.styleable.d_edittext_d_password, false);
    int typeFont = ta.getInt(R.styleable.d_edittext_d_font, 0);
    isEmail = ta.getBoolean(R.styleable.d_edittext_d_email, false);
    int inputType = ta.getInt(R.styleable.d_edittext_d_inputType, 0x00000021);
    isBankCard = ta.getBoolean(R.styleable.d_edittext_d_isBankCard, false);
    isPhone = ta.getBoolean(R.styleable.d_edittext_d_phone, false);
    //设置字体颜色
    mEditText.setTextColor(ta.getColor(R.styleable.d_edittext_d_textColor, getResources().getColor(android.R.color.black)));
    int drawableId = ta.getResourceId(R.styleable.d_edittext_d_background, R.drawable.login_edittext_bg);
    int textSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20, MeasureUtil.getDisplayMetrics());
    textSize = ta.getDimensionPixelSize(R.styleable.d_edittext_d_textSize,textSize);
    mGridView.setAdapter(new BaseAdapter() {

      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.login_auto_complete_text_item, null);
        final DTextView ihaveuTextView = (DTextView) convertView.findViewById(R.id.text);
        ihaveuTextView.setText(getItem(position));
        ihaveuTextView.setOnClickListener(new OnClickListener() {

          @Override
          public void onClick(View v) {
            setText(getText() + ihaveuTextView.getText().toString());
            mPopupWindow.dismiss();
            getEditText().setSelection(getText().length());
          }
        });
        return ihaveuTextView;
      }

      @Override
      public long getItemId(int position) {
        return position;
      }

      @Override
      public String getItem(int position) {
        return mEmailSufixs[position];
      }

      @Override
      public int getCount() {
        return mEmailSufixs.length;
      }
    });
    //设置字体大小
    setTextSize(textSize);
    //设置输入框背景颜色
    setBackground(drawableId);
    //设置singleline 注意 设置行数要在设置输入类型之前设置 ！！！
    if (maxLine <= 1) {
      mEditText.setSingleLine(true);
      //设置输入框样式 需要的自行补充 attrs 文件
      mEditText.setInputType(inputType);
    } else {
      //设置最大行数又设置输入类型就无效了  这里就不选择输入类型了
      mEditText.setSingleLine(false);
      mEditText.setMaxLines(maxLine);
    }
    //设置密码样式
    if (isPassword) {
      mEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
      setPasswordStyle('*');
    }
    //设置文字字体
    setTypeface(typeFont);
    //获取错误提示文字
    mNotNull = ta.getBoolean(R.styleable.d_edittext_verifyNotNull, false);
    if (mNotNull) {
      mNotNullAlert = ta.getResources().getString(ta.getResourceId(R.styleable.d_edittext_alertNotNull, R.string.empty));
    }
    //设置最大长度
    if (maxLength != 0) {
      InputFilter[] filters = {new InputFilter.LengthFilter(maxLength)};
      mEditText.setFilters(filters);
    }
    //设置删除按钮点击逻辑
    mDeleteButton.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        mEditText.setText("");
        mEditText.setError(null);
      }
    });
    //设置文字改变逻辑
    mEditText.addTextChangedListener(new TextWatcher() {

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        //这里应该判断输入框是否有内容而不是 count
        if (mEditText.getText().length() > 0) {
          mDeleteButton.setVisibility(View.VISIBLE);
        } else {
          mDeleteButton.setVisibility(View.GONE);
        }
        //如果是输入的银行卡
        if (isBankCard) {
          if (s.length() == 5 || s.length() == 10 || s.length() == 15 || s.length() == 20) {
            String left = s.toString().substring(0, s.length() - 1);
            String right = s.toString().substring(s.length() - 1, s.length());
            mEditText.setText(left + " " + right);
            setSelectionInLast();
          }
        }
        else if(isPhone){
          if (s.length()>0&&s.charAt(0)-'1'!=0) {
            mEditText.setError("您输入的手机号格式有误", mDrawable);
          }
        }
      }

      @Override
      public void beforeTextChanged(CharSequence s, int start, int count,
                                    int after) {

      }

      @Override
      public void afterTextChanged(Editable s) {
        if (isEmail) {
          if ((getText().indexOf("@") == getText().length() - 1) && (getText().indexOf("@") != -1)) {
            mPopupWindow.showAsDropDown(mEditText, 0, -MeasureUtil.dip2px(3));
          }
        }
      }
    });
    //获得焦点时候的逻辑
    mEditText.setOnFocusChangeListener(new OnFocusChangeListener() {

      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus && getText().length() > 0) {
          mDeleteButton.setVisibility(View.VISIBLE);
        } else {
          mDeleteButton.setVisibility(View.GONE);
        }
      }
    });
    //键盘输入与edittext的交互
    mEditText.setOnKeyListener(new OnKeyListener() {

      @Override
      public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (isBankCard) {
          if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_UP) {
            if (mEditText.getText().length() == 21 || mEditText.getText().length() == 16 || mEditText.getText().length() == 11 || mEditText.getText().length() == 6) {
              deleteLastTwoWords();
            }
          }
        }
        return false;
      }
    });
    ta.recycle();
  }

  /**
   * 设置hint
   * @param resid
   */
  public void setD_hint(int resid) {
    mEditText.setHint(resid);
  }

  /**
   * 获得删除按钮
   * @return
   */
  public ImageButton getDeleteButton() {
    return mDeleteButton;
  }

  /**
   * 设置删除按钮
   * @param id
   */
  public void setDeleteBtnImage(int id){
    getDeleteButton().setImageResource(id);
  }
  /**
   * 设置出错信息
   *
   * @param text
   */
  public void setError(String text) {
    mEditText.setError(text, mDrawable);
  }
  /**
   * 设置光标在最后一位
   */
  private void setSelectionInLast() {
    CharSequence text = mEditText.getText();
    if (text instanceof Spannable) {
      Spannable spanText = (Spannable) text;
      Selection.setSelection(spanText, text.length());
    }
  }
  /**
   * 删除最后两位 字符  并且将光标放在最后
   */
  private void deleteLastTwoWords() {
    String text = mEditText.getText().toString();
    text = text.substring(0, text.length() - 2);
    mEditText.setText(text);
    setSelectionInLast();
  }
  /**
   * 设置密码暗码样式
   *
   * @param indicator
   */
  public void setPasswordStyle(char indicator) {
    mEditText.setTransformationMethod(new AsteriskPasswordTransformationMethod(indicator));
  }


  /**
   * 获取编辑框
   * @return
   */
  public EditText getEditText() {
    return mEditText;
  }
  /**
   * 获取文本
   *
   * @return
   */
  public String getText() {
    return mEditText.getText().toString();
  }

  /**
   * 设置文本
   *
   * @param text
   */
  public void setText(String text) {
    mEditText.setText(text);
  }
  /**
   * 设置输入框背景颜色
   *
   * @param id
   */
  public void setBackground(int id) {
    mEditText.setBackgroundResource(id);
  }

  /**
   * 设置文字尺寸
   * @param size
   */
  public void setTextSize(float size) {
    mEditText.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
  }
  /**
   * 设置字体
   *
   * @param type
   */
  public void setTypeface(int type) {
    TextUtil.setFont(mEditText, type);
  }
}
