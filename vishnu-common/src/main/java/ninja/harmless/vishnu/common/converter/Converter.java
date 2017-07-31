package ninja.harmless.vishnu.common.converter;

/**
 * @author bnjm@harmless.ninja - 7/31/17.
 */
public interface Converter<T,S> {
    T convert(S obj);
}
