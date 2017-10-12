package com.rabtman.acgclub.mvp.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rabtman.acgclub.R;
import com.rabtman.acgclub.mvp.model.jsoup.ScheduleNew.ScheduleNewItem;
import com.rabtman.common.imageloader.ImageLoader;
import com.rabtman.common.imageloader.glide.GlideImageConfig;

/**
 * @author Rabtman
 */

public class ScheduleNewAdapter extends BaseQuickAdapter<ScheduleNewItem, BaseViewHolder> {

  private ImageLoader mImageLoader;

  public ScheduleNewAdapter(ImageLoader imageLoader) {
      super(R.layout.item_schedule_new_test, null);
    mImageLoader = imageLoader;
  }


  @Override
  protected void convert(BaseViewHolder helper, ScheduleNewItem item) {
    helper.setText(R.id.schedule_new_title, item.getTitle())
        .setText(R.id.schedule_new_spot, item.getSpot())
        .setText(R.id.schedule_new_type, item.getType())
        .setText(R.id.schedule_new_desc, item.getDesc());
    mImageLoader.loadImage(mContext,
        GlideImageConfig
            .builder()
            .url(item.getImgUrl())
            .imagerView((ImageView) helper.getView(R.id.schedule_new_img))
            .build()
    );
  }
}