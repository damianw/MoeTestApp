package wtf.log.moetestapp.ios

import apple.NSObject
import apple.foundation.NSData
import apple.uikit.UIImage
import org.moe.natj.general.NatJ
import org.moe.natj.general.Pointer
import org.moe.natj.general.ann.RegisterOnStartup
import org.moe.natj.general.ptr.impl.PtrFactory
import org.moe.natj.objc.ann.ObjCClassName
import org.moe.natj.objc.ann.Selector
import wtf.log.moetestapp.common.SampleSharedApi

/**
 * @author Damian Wieczorek <damian@farmlogs.com>
 * @since 3/16/17
 * (C) 2017
 */
@RegisterOnStartup
@ObjCClassName("ImageProvider")
class ImageProvider(peer: Pointer) : NSObject(peer) {

  @Selector("fetchImage")
  fun fetchImage(): UIImage {
    val bytes = SampleSharedApi.fetchImage()
    val data = NSData.alloc().initWithBytesLength(PtrFactory.newByteArray(bytes), bytes.size.toLong())
    return UIImage.alloc().initWithData(data)
  }

  companion object {

    init {
      NatJ.register()
    }

  }

}
