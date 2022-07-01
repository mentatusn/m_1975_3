package com.gb.m_1975_3.view.layouts.behaviors

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

//class NestedBehavior():CoordinatorLayout.Behavior<NestedScrollView> {
class MyAnchorBehavior(context: Context, attr: AttributeSet? = null) :
    CoordinatorLayout.Behavior<View>(context, attr) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return (dependency is AppBarLayout)
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {

        if (dependency is AppBarLayout) {
            child.y = dependency.height.toFloat() + dependency.y
        }
        return super.onDependentViewChanged(parent, child, dependency)
    }
}