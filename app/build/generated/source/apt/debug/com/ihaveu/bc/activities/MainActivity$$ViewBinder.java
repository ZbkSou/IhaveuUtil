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
    view = finder.findRequiredView(source, 2131492991, "field 'requestText'");
    target.requestText = finder.castView(view, 2131492991, "field 'requestText'");
    view = finder.findRequiredView(source, 2131492995, "field 'getRequest' and method 'onClick'");
    target.getRequest = finder.castView(view, 2131492995, "field 'getRequest'");
    unbinder.view2131492995 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492998, "field 'loginButton' and method 'onClick'");
    target.loginButton = finder.castView(view, 2131492998, "field 'loginButton'");
    unbinder.view2131492998 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492992, "field 'requestImage'");
    target.requestImage = finder.castView(view, 2131492992, "field 'requestImage'");
    view = finder.findRequiredView(source, 2131492996, "field 'getImageRequest' and method 'onClick'");
    target.getImageRequest = finder.castView(view, 2131492996, "field 'getImageRequest'");
    unbinder.view2131492996 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492997, "field 'clearImageCache' and method 'onClick'");
    target.clearImageCache = finder.castView(view, 2131492997, "field 'clearImageCache'");
    unbinder.view2131492997 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131493000, "field 'getuerButton' and method 'onClick'");
    target.getuerButton = finder.castView(view, 2131493000, "field 'getuerButton'");
    unbinder.view2131493000 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492999, "field 'logoutButton' and method 'onClick'");
    target.logoutButton = finder.castView(view, 2131492999, "field 'logoutButton'");
    unbinder.view2131492999 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131493001, "field 'registerButton' and method 'onClick'");
    target.registerButton = finder.castView(view, 2131493001, "field 'registerButton'");
    unbinder.view2131493001 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131493002, "field 'getGoodsListButton' and method 'onClick'");
    target.getGoodsListButton = finder.castView(view, 2131493002, "field 'getGoodsListButton'");
    unbinder.view2131493002 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131493003, "field 'showDataButton' and method 'onClick'");
    target.showDataButton = finder.castView(view, 2131493003, "field 'showDataButton'");
    unbinder.view2131493003 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131493004, "field 'getDataButton' and method 'onClick'");
    target.getDataButton = finder.castView(view, 2131493004, "field 'getDataButton'");
    unbinder.view2131493004 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492993, "field 'imagePick' and method 'onClick'");
    target.imagePick = finder.castView(view, 2131492993, "field 'imagePick'");
    unbinder.view2131492993 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131492994, "field 'imageDownload' and method 'onClick'");
    target.imageDownload = finder.castView(view, 2131492994, "field 'imageDownload'");
    unbinder.view2131492994 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131493005, "field 'newWidgetButton' and method 'onClick'");
    target.newWidgetButton = finder.castView(view, 2131493005, "field 'newWidgetButton'");
    unbinder.view2131493005 = view;
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

    View view2131492995;

    View view2131492998;

    View view2131492996;

    View view2131492997;

    View view2131493000;

    View view2131492999;

    View view2131493001;

    View view2131493002;

    View view2131493003;

    View view2131493004;

    View view2131492993;

    View view2131492994;

    View view2131493005;

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
      view2131492995.setOnClickListener(null);
      target.getRequest = null;
      view2131492998.setOnClickListener(null);
      target.loginButton = null;
      target.requestImage = null;
      view2131492996.setOnClickListener(null);
      target.getImageRequest = null;
      view2131492997.setOnClickListener(null);
      target.clearImageCache = null;
      view2131493000.setOnClickListener(null);
      target.getuerButton = null;
      view2131492999.setOnClickListener(null);
      target.logoutButton = null;
      view2131493001.setOnClickListener(null);
      target.registerButton = null;
      view2131493002.setOnClickListener(null);
      target.getGoodsListButton = null;
      view2131493003.setOnClickListener(null);
      target.showDataButton = null;
      view2131493004.setOnClickListener(null);
      target.getDataButton = null;
      view2131492993.setOnClickListener(null);
      target.imagePick = null;
      view2131492994.setOnClickListener(null);
      target.imageDownload = null;
      view2131493005.setOnClickListener(null);
      target.newWidgetButton = null;
    }
  }
}
