package com.dilip.marketplace.ui.home;

import com.dilip.marketplace.ui.OrderDetailsActivity;
import com.dilip.marketplace.ui.horizontal_product_view.HorizontalProductScrollModel;

import java.util.List;

public class HomePageModel {
    public static final int BANNER_SLIDER = 0;
    public static final int STRIP_AD_BANNER = 1;
    public static final int HORIZONTAL_PRODUCT_VIEW = 2;
    public static final int GRID_PRODUCT_VIEW = 3;
    private int type;

    ///////// Banner Slider
    private List<OrderDetailsActivity.SliderModel> sliderModelList;

    public HomePageModel(int type, List<OrderDetailsActivity.SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<OrderDetailsActivity.SliderModel> getSliderModelList() {
        return sliderModelList;
    }

    public void setSliderModelList(List<OrderDetailsActivity.SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }
    ///////// Banner Slider


    //////// Strip Ad
    private int resource;
    private String backgroundColor;

    public HomePageModel(int type) {
        this.type = type;
    }

    public HomePageModel(int type, int resource, String backgroundColor) {
        this.type = type;
        this.resource = resource;
        this.backgroundColor = backgroundColor;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    /////// Strip Ad

    ///////// Horizontal Product Layout & Grid Product Layout
    private String title;
    private List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    public HomePageModel(int type, String title, List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.type = type;
        this.title = title;
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HorizontalProductScrollModel> getHorizontalProductScrollModelList() {
        return horizontalProductScrollModelList;
    }

    public void setHorizontalProductScrollModelList(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }
    ///////// Horizontal Product Layout & Grid Product Layout

}
