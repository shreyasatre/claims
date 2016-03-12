package org.troytemple.transformer;

/**
 * Created by bt_te on 3/4/2016.
 */
public interface ITransformer<T,R> {

    R transform(T request);
}
