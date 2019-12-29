---
description: >-
  Model Mapper DTO katmanımızdaki işlem yükümüzü alır ve geliştirmeyi
  hızlandırır. Bunu da Proje -ana- sınıfımızda bir bean olarak tanımlar ver her
  yerden bu instansa erişim sağlarız.
---

# Model Mapper

![](../../../.gitbook/assets/screenshot-from-2019-07-02-15-27-48.png)

```text
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
```



