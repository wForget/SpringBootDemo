package cn.wangz.springboot.service;

import cn.wangz.springboot.conf.HBaseProperties;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by hadoop on 2019/1/10.
 */
@Service
public class HbaseService {
    @Autowired
    private HbaseTemplate hbaseTemplate;

    @Autowired
    private HBaseProperties hBaseProperties;

    public String get(String rowKey) {
        return hbaseTemplate.get(hBaseProperties.getTable(), rowKey
                , (result, rowNum) -> Bytes.toString(result.getValue("family".getBytes(), "qualifier".getBytes())));
    }

    public String excute(String rowKey) {
        return hbaseTemplate.execute(hBaseProperties.getTable(), table -> {
            Result result = table.get(new Get(rowKey.getBytes()));
            return Bytes.toString(result.getValue("family".getBytes(), "qualifier".getBytes()));
        });
    }
}
