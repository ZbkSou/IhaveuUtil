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

public class LoginActivity$$ViewBinder<T extends LoginActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131427412, "field 'username'");
    target.username = finder.castView(view, 2131427412, "field 'username'");
    view = finder.findRequiredView(source, 2131427413, "field 'password'");
    target.password = finder.castView(view, 2131427413, "field 'password'");
    view = finder.findRequiredView(source, 2131427414, "field 'login' and method 'onClick'");
    target.login = finder.castView(view, 2131427414, "field 'login'");
    unbinder.view2131427414 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends LoginActivity> implements Unbinder {
    private T target;

    View view2131427414;

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
      target.username = null;
      target.password = null;
      view2131427414.setOnClickListener(null);
      target.login = null;
    }
  }
}
