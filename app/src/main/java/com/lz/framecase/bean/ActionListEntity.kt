package com.lz.framecase.bean

import java.io.Serializable

/**
 * -----------作者----------日期----------变更内容-----
 * -          刘泽      2018-08-29       创建class
 */
 class ActionListEntity : Serializable {
    /**
     * action : 1
     * desc :
     * extra : {}
     */

    var action: Int = 0
    var desc: String? = null
    var extra: ExtraEntity? = null
}
