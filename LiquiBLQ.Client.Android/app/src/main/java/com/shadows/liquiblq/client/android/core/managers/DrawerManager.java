package com.shadows.liquiblq.client.android.core.managers;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by John on 27.4.2016 г..
 */
public class DrawerManager {
    public static NavigationView ShowInfoPanel(Activity parent, int HeaderView,int MenuId){
        NavigationView Panel = new NavigationView(parent);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.RIGHT;
        Panel.setLayoutParams(params);
        Panel.setFitsSystemWindows(true);
        Panel.inflateHeaderView(HeaderView);
        Panel.inflateMenu(MenuId);
        return Panel;
    }
}
