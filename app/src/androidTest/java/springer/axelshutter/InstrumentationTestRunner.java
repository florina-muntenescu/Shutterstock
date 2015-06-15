package springer.axelshutter;

import android.os.Bundle;
import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.TestSuite;

/**
 * Our custom instrumentation test runner.
 * Can be removed if contents get unnecessary over time.
 */
public class InstrumentationTestRunner extends android.test.InstrumentationTestRunner {

    @Override public void onCreate (final Bundle arguments) {
        super.onCreate(arguments);

        // temporary workaround for an incompatibility in current dexmaker (1.1) implementation and Android >= 4.3
        // cf. https://code.google.com/p/dexmaker/issues/detail?id=2 for details
        // TODO remove once fixed upstream
        System.setProperty("dexmaker.dexcache", getTargetContext().getCacheDir().toString());
    }

}
