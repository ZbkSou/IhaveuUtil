// Generated code from Butter Knife. Do not modify!
package com.ihaveu.bc.activities;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MainActivity$$ViewBinder<T extends MainActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131427415, "field 'requestText'");
    target.requestText = finder.castView(view, 2131427415, "field 'requestText'");
    view = finder.findRequiredView(source, 2131427417, "field 'getRequest' and method 'onClick'");
    target.getRequest = finder.castView(view, 2131427417, "field 'getRequest'");
    unbinder.view2131427417 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427420, "field 'loginButton' and method 'onClick'");
    target.loginButton = finder.castView(view, 2131427420, "field 'loginButton'");
    unbinder.view2131427420 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427416, "field 'requestImage'");
    target.requestImage = finder.castView(view, 2131427416, "field 'requestImage'");
    view = finder.findRequiredView(source, 2131427418, "field 'getImageRequest' and method 'onClick'");
    target.getImageRequest = finder.castView(view, 2131427418, "field 'getImageRequest'");
    unbinder.view2131427418 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427419, "field 'clearImageCache' and method 'onClick'");
    target.clearImageCache = finder.castView(view, 2131427419, "field 'clearImageCache'");
    unbinder.view2131427419 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427422, "field 'getuerButton' and method 'onClick'");
    target.getuerButton = finder.castView(view, 2131427422, "field 'getuerButton'");
    unbinder.view2131427422 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427421, "field 'logoutButton' and method 'onClick'");
    target.logoutButton = finder.castView(view, 2131427421, "field 'logoutButton'");
    unbinder.view2131427421 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427423, "field 'registerButton' and method 'onClick'");
    target.registerButton = finder.castView(view, 2131427423, "field 'registerButton'");
    unbinder.view2131427423 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends MainActivity> implements Unbinder {
    private T target;

    View view2131427417;

    View view2131427420;

    View view2131427418;

    View view2131427419;

    View view2131427422;

    View view2131427421;

    View view2131427423;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.requestText = null;
      view2131427417.setOnClickListener(null);
      target.getRequest = null;
      view2131427420.setOnClickListener(null);
      target.loginButton = null;
      target.requestImage = null;
      view2131427418.setOnClickListener(null);
      target.getImageRequest = null;
      view2131427419.setOnClickListener(null);
      target.clearImageCache = null;
      view2131427422.setOnClickListener(null);
      target.getuerButton = null;
      view2131427421.setOnClickListener(null);
      target.logoutButton = null;
      view2131427423.setOnClickListener(null);
      target.registerButton = null;
    }
  }
}
