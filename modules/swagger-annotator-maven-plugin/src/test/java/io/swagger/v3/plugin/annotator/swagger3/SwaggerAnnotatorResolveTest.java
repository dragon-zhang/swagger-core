package io.swagger.v3.plugin.annotator.swagger3;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.plugin.annotator.swagger3.resource.TestController;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Method;

public class SwaggerAnnotatorResolveTest extends BaseSwaggerMavenIntegrationTest {

    protected static Logger LOGGER = LoggerFactory.getLogger(SwaggerAnnotatorResolveTest.class);

    /**
     * Do not run this test case directly,
     * just use the "mvn clean install" command
     */
    public void testResolve() throws Exception {
        File pom = getTestFile("src/test/resources/pom.testSwagger3AnnotatorMojo.xml");
        runTest(pom);
        Api api = TestController.class.getDeclaredAnnotation(Api.class);
        Assert.assertNotNull(api);
        Method method = TestController.class.getDeclaredMethod("test", String.class);
        Operation operation = method.getDeclaredAnnotation(Operation.class);
        ApiResponse apiResponse = method.getDeclaredAnnotation(ApiResponse.class);
        Assert.assertNotNull(operation);
        Assert.assertNotNull(apiResponse);
    }

}
