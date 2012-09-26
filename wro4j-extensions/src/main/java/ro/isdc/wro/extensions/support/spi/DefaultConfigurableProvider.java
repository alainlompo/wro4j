package ro.isdc.wro.extensions.support.spi;

import java.util.Map;

import ro.isdc.wro.extensions.http.handler.spi.DefaultRequestHandlerProvider;
import ro.isdc.wro.extensions.processor.support.DefaultProcessorProvider;
import ro.isdc.wro.http.handler.RequestHandler;
import ro.isdc.wro.http.handler.spi.RequestHandlerProvider;
import ro.isdc.wro.model.resource.processor.ResourceProcessor;
import ro.isdc.wro.model.resource.processor.support.ProcessorProvider;
import ro.isdc.wro.util.provider.ConfigurableProviderSupport;

/**
 * Default implementation of {@link ConfigurableProviderSupport} which contributes with components from extensions module.
 * 
 * @author Alex Objelean
 * @created 23 Sep 2012
 * @since 1.4.10
 */
public class DefaultConfigurableProvider
    extends ConfigurableProviderSupport {
  private ProcessorProvider processorProvider = new DefaultProcessorProvider();
  private RequestHandlerProvider requestHandlerProvider = new DefaultRequestHandlerProvider();
  
  /**
   * {@inheritDoc}
   */
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
  public Map<String, RequestHandler> provideRequestHandlers() {
    return requestHandlerProvider.provideRequestHandlers();
  }
}
