package com.ihaveu.bc.utils;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

/**
 * Created by bc on 16/10/12.
 * Describe
 */
public class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
  char mIndicator;
  public AsteriskPasswordTransformationMethod(char indicator){
    mIndicator = indicator;
  }
  @Override
  public CharSequence getTransformation(CharSequence source, View view) {
    return new PasswordCharSequence(source);
  }
  private class PasswordCharSequence implements CharSequence {
    private CharSequence mSource;
    public PasswordCharSequence(CharSequence source) {
      mSource = source; // Store char sequence
    }
    public char charAt(int index) {
      return mIndicator; // This is the important part
    }
    public int length() {
      return mSource.length(); // Return default
    }
    public CharSequence subSequence(int start, int end) {
      return mSource.subSequence(start, end); // Return default
    }
  }
}
