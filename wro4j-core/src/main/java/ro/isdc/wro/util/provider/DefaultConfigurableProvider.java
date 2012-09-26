package ro.isdc.wro.util.provider;

import java.util.Map;

import ro.isdc.wro.cache.CacheStrategy;
import ro.isdc.wro.cache.spi.CacheStrategyProvider;
import ro.isdc.wro.cache.spi.DefaultCacheStrategyProvider;
import ro.isdc.wro.http.handler.RequestHandler;
import ro.isdc.wro.http.handler.spi.DefaultRequestHandlerProvider;
import ro.isdc.wro.http.handler.spi.RequestHandlerProvider;
import ro.isdc.wro.model.resource.locator.factory.ResourceLocatorFactory;
import ro.isdc.wro.model.resource.locator.support.DefaultLocatorProvider;
import ro.isdc.wro.model.resource.locator.support.LocatorProvider;
import ro.isdc.wro.model.resource.processor.ResourceProcessor;
import ro.isdc.wro.model.resource.processor.support.DefaultProcessorProvider;
import ro.isdc.wro.model.resource.processor.support.ProcessorProvider;
import ro.isdc.wro.model.resource.support.hash.DefaultHashStrategyProvider;
import ro.isdc.wro.model.resource.support.hash.HashStrategy;
import ro.isdc.wro.model.resource.support.hash.HashStrategyProvider;
import ro.isdc.wro.model.resource.support.naming.DefaultNamingStrategyProvider;
import ro.isdc.wro.model.resource.support.naming.NamingStrategy;
import ro.isdc.wro.model.resource.support.naming.NamingStrategyProvider;

/**
 * Default implementation of {@link ConfigurableProviderSupport} which contributes with components from core module.
 * 
 * @author Alex Objelean
 * @created 16 Jun 2012
 * @since 1.4.7
 */
public class DefaultConfigurableProvider
    extends ConfigurableProviderSupport {
  private final ProcessorProvider processorProvider = new DefaultProcessorProvider();
  private final NamingStrategyProvider namingStrategyProvider = new DefaultNamingStrategyProvider();
  private final HashStrategyProvider hashStrategyProvider = new DefaultHashStrategyProvider();
  private final LocatorProvider locatorProvider = new DefaultLocatorProvider();
  private final CacheStrategyProvider cacheStrategyProvider = new DefaultCacheStrategyProvider();
  private final RequestHandlerProvider requestHandlerProvider = new DefaultRequestHandlerProvider();
  
  /**
   * {@inheritDoc}
   */
  @Override
  public java.util.Map<String,ResourceProcessor> providePreProcessors() {
    return processorProvider.providePreProcessors();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, ResourceProcessor> providePostProcessors() {
    return processorProvider.providePostProcessors();
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, HashStrategy> provideHashStrategies() {
    return hashStrategyProvider.provideHashStrategies();
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, NamingStrategy> provideNamingStrategies() {
    return namingStrategyProvider.provideNamingStrategies();
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, CacheStrategy> provideCacheStrategies() {
    return cacheStrategyProvider.provideCacheStrategies();
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, ResourceLocatorFactory> provideLocators() {
    return locatorProvider.provideLocators();
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, RequestHandler> provideRequestHandlers() {
    return requestHandlerProvider.provideRequestHandlers();
  }
}
