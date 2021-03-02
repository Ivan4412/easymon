package com.meerkat.easymon.service;

import com.meerkat.easymon.data.gen.model.TReceiver;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2018/6/5.
 */
@Service
public interface ReceiverService {

    /**
     * 根据Id查找接收人
     */

    public TReceiver findReceiverById(String id);

}
