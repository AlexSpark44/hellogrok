package com.hellogrok.architecture;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

/**
 * Architecture tests using ArchUnit.
 */
class HexagonalArchitectureTest {

    private static final String BASE_PACKAGE = "com.hellogrok";

    @Test
    void domainLayerShouldNotDependOnAnyOtherLayer() {
        ArchRule rule = noClasses()
                .that().resideInAPackage(BASE_PACKAGE + ".domain..")
                .should().dependOnClassesThat()
                .resideInAnyPackage(
                        BASE_PACKAGE + ".application..",
                        BASE_PACKAGE + ".adapter..",
                        BASE_PACKAGE + ".port..",
                        BASE_PACKAGE + ".config.."
                );

        rule.check(new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages(BASE_PACKAGE));
    }

    @Test
    void applicationLayerShouldOnlyDependOnDomainAndPorts() {
        ArchRule rule = noClasses()
                .that().resideInAPackage(BASE_PACKAGE + ".application..")
                .should().dependOnClassesThat()
                .resideInAnyPackage(
                        BASE_PACKAGE + ".adapter..",
                        BASE_PACKAGE + ".config.."
                );

        rule.check(new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages(BASE_PACKAGE));
    }

    @Test
    void portsShouldNotDependOnAdapters() {
        ArchRule rule = noClasses()
                .that().resideInAPackage(BASE_PACKAGE + ".port..")
                .should().dependOnClassesThat()
                .resideInAPackage(BASE_PACKAGE + ".adapter..");

        rule.check(new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages(BASE_PACKAGE));
    }
}
