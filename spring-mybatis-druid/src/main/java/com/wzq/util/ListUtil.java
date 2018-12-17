package com.wzq.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述:
 * list集合工具类
 *
 * @author 顺丰科技开源(opensource @ sfmail.sf - express.com)
 * @version 1.7
 * @date 2018-12-12 18:20
 */
public class ListUtil {

    /**
     * 将一个list均分成多个list， 每个list的长度为n
     * @param source 需要分割的list
     * @param n 每段list的长度
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> source, int n) throws Exception {
        if(source.isEmpty() || source == null){
            throw new Exception("list is empty or is null");
        }

        if(n <= 0){
            throw new Exception("split num can not less than or equal to zero");
        }

        List<List<T>> result=new ArrayList<>();
        if(source.size() < n){
            result.add(source);
            return result;
        }

        //计算出余数
        int remaider=source.size()%n;
        //计算商值
        int number=source.size()/n;
        if(remaider > 0){
           number++;
        }
        for(int i=0;i<number;i++){
            List<T> value=null;

            if(remaider>0 && i==(number-1)){
                value=source.subList(n*i, source.size());
            }else{
                value=source.subList(n*i, n*(i+1));
            }
            result.add(value);
        }
        return result;
    }

    /**
     * 将一个list均分成n个list,主要通过偏移量来实现的
     * @param source 要分割的list
     * @param n 分成n个list
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source,int n){
        List<List<T>> result=new ArrayList<>();
        //计算出余数
        int remaider=source.size()%n;
        //计算商值
        int number=source.size()/n;
        //偏移量
        int offset=0;
        for(int i=0;i<n;i++){
            List<T> value=null;
            if(remaider>0){
                value=source.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=source.subList(i*number+offset, (i+1)*number+offset);
            }
            result.add(value);
        }
        return result;
    }

}
