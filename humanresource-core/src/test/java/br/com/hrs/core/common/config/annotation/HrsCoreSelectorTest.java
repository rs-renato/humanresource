package br.com.hrs.core.common.config.annotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HrsCoreSelectorTest {

    HrsCoreSelector hrsCoreSelector;

    @BeforeEach
    void setUp() {
        hrsCoreSelector = new HrsCoreSelector();
    }

    @Test
    void selectImportsNome() {

        String[] selectImports = hrsCoreSelector.selectImports(AnnotationMetadata.introspect(DummyLoadNone.class));
        assertNull(selectImports);
    }

    @Test
    void selectImportsUseCase() {

        String[] selectImports = hrsCoreSelector.selectImports(AnnotationMetadata.introspect(DummyLoadUseCase.class));
        assertNotNull(selectImports);
        Stream.of(selectImports)
                .forEach(clazz -> assertTrue(clazz.matches("^br\\.com\\.hrs\\.core\\.usecase.*UseCase$")));
    }

    @Test
    void selectImportsRepositoryUseCase() {

        String[] selectImports = hrsCoreSelector.selectImports(AnnotationMetadata.introspect(DummyLoadRepositoryUseCase.class));
        assertNotNull(selectImports);
        Stream.of(selectImports)
                .forEach(clazz -> assertTrue(clazz.matches("^br\\.com\\.hrs\\.core.*(repository|usecase).*(Repository|UseCase)$")));
    }

    @Test
    void selectImportsRepositoryUseCaseValidator() {

        String[] selectImports = hrsCoreSelector.selectImports(AnnotationMetadata.introspect(DummyLoadRepositoryUseCaseValidator.class));
        assertNotNull(selectImports);
        Stream.of(selectImports)
                .forEach(clazz -> assertTrue(clazz.matches("^br\\.com\\.hrs\\.core.*(repository|usecase|validator).*(Repository|UseCase|Validator)$")));
    }

    class DummyLoadNone {}

    @EnableHrsCore(loadValidators = false, loadMockRepository = false)
    class DummyLoadUseCase {}

    @EnableHrsCore(loadValidators = false, loadMockRepository = true)
    class DummyLoadRepositoryUseCase {}

    @EnableHrsCore(loadValidators = true, loadMockRepository = true)
    class DummyLoadRepositoryUseCaseValidator {}
}