package wtf.log.moetestapp.android.app

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import wtf.log.moetestapp.R
import wtf.log.moetestapp.common.SampleSharedApi

class MainActivity : AppCompatActivity() {

  private var subscription: Subscription? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  override fun onStart() {
    super.onStart()
    subscription = Observable
        .fromCallable(SampleSharedApi::fetchImage)
        .map { BitmapFactory.decodeByteArray(it, 0, it.size) }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(activity_main_image::setImageBitmap)
  }

  override fun onStop() {
    super.onStop()
    subscription?.unsubscribe()
  }

}
