package ro.isdc.wro.model.spi;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.isdc.wro.model.WroModel;
import ro.isdc.wro.model.factory.WroModelFactory;
import ro.isdc.wro.model.factory.XmlModelFactory;
import ro.isdc.wro.model.resource.support.AbstractConfigurableSingleStrategy;


/**
 * @author Alex Objelean
 * @created 4 Jan 2013
 * @since 1.6.3
 */
public class ConfigurableModelFactory
    extends AbstractConfigurableSingleStrategy<WroModelFactory, ModelFactoryProvider>
    implements WroModelFactory {
  private static final Logger LOG = LoggerFactory.getLogger(ConfigurableModelFactory.class);
  /**
   * Property name to specify alias.
   */
  public static final String KEY = "modelFactory";
  /**
   * {@inheritDoc}
   */
  @Override
  protected WroModelFactory getDefaultStrategy() {
    try {
      LOG.debug("Trying to use SmartWroModelFactory as default model factory");
      final Class<? extends WroModelFactory> smartFactoryClass = Class.forName(
          "ro.isdc.wro.extensions.model.factory.SmartWroModelFactory").asSubclass(WroModelFactory.class);
      return smartFactoryClass.newInstance();
    } catch (final Exception e) {
      LOG.debug("SmartWroModelFactory is not available. Using default model factory.");
      LOG.debug("Reason: {}", e.getMessage());
    }
    return new XmlModelFactory();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Map<String, WroModelFactory> getStrategies(final ModelFactoryProvider provider) {
    return provider.provideModelFactories();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected String getStrategyKey() {
    return KEY;
  }

  /**
   * {@inheritDoc}
   */
  public WroModel create() {
    return getConfiguredStrategy().create();
  }

  /**
   * {@inheritDoc}
   */
  public void destroy() {
    getConfiguredStrategy().destroy();
  }
}
