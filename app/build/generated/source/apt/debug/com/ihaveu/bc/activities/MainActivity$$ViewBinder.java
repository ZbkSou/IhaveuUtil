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
    view = finder.findRequiredView(source, 2131492979, "field 'requestText'");
    target.requestText = finder.castView(view, 2131492979, "field 'requestText'");
    view = finder.findRequiredView(source, 2131492981, "field 'getRequest' and method 'onClick'");
    target.getRequest = finder.castView(view, 2131492981, "field 'getRequest'");
    unbinder.view2131492981 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492984, "field 'loginButton' and method 'onClick'");
    target.loginButton = finder.castView(view, 2131492984, "field 'loginButton'");
    unbinder.view2131492984 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492980, "field 'requestImage'");
    target.requestImage = finder.castView(view, 2131492980, "field 'requestImage'");
    view = finder.findRequiredView(source, 2131492982, "field 'getImageRequest' and method 'onClick'");
    target.getImageRequest = finder.castView(view, 2131492982, "field 'getImageRequest'");
    unbinder.view2131492982 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492983, "field 'clearImageCache' and method 'onClick'");
    target.clearImageCache = finder.castView(view, 2131492983, "field 'clearImageCache'");
    unbinder.view2131492983 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492986, "field 'getuerButton' and method 'onClick'");
    target.getuerButton = finder.castView(view, 2131492986, "field 'getuerButton'");
    unbinder.view2131492986 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492985, "field 'logoutButton' and method 'onClick'");
    target.logoutButton = finder.castView(view, 2131492985, "field 'logoutButton'");
    unbinder.view2131492985 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492987, "field 'registerButton' and method 'onClick'");
    target.registerButton = finder.castView(view, 2131492987, "field 'registerButton'");
    unbinder.view2131492987 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492988, "field 'getGoodsListButton' and method 'onClick'");
    target.getGoodsListButton = finder.castView(view, 2131492988, "field 'getGoodsListButton'");
    unbinder.view2131492988 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492989, "field 'showDataButton' and method 'onClick'");
    target.showDataButton = finder.castView(view, 2131492989, "field 'showDataButton'");
    unbinder.view2131492989 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492990, "field 'getDataButton' and method 'onClick'");
    target.getDataButton = finder.castView(view, 2131492990, "field 'getDataButton'");
    unbinder.view2131492990 = view;
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

    View view2131492981;

    View view2131492984;

    View view2131492982;

    View view2131492983;

    View view2131492986;

    View view2131492985;

    View view2131492987;

    View view2131492988;

    View view2131492989;

    View view2131492990;

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
      view2131492981.setOnClickListener(null);
      target.getRequest = null;
      view2131492984.setOnClickListener(null);
      target.loginButton = null;
      target.requestImage = null;
      view2131492982.setOnClickListener(null);
      target.getImageRequest = null;
      view2131492983.setOnClickListener(null);
      target.clearImageCache = null;
      view2131492986.setOnClickListener(null);
      target.getuerButton = null;
      view2131492985.setOnClickListener(null);
      target.logoutButton = null;
      view2131492987.setOnClickListener(null);
      target.registerButton = null;
      view2131492988.setOnClickListener(null);
      target.getGoodsListButton = null;
      view2131492989.setOnClickListener(null);
      target.showDataButton = null;
      view2131492990.setOnClickListener(null);
      target.getDataButton = null;
    }
  }
}
