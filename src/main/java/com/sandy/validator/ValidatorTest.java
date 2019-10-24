package com.sandy.validator;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.IOException;

public class ValidatorTest {
    public static void main(String args[]) throws IOException, ProcessingException {

        final JsonNode fstabSchema = ResourceUtils.loadResource("/schema_test.json");
        final JsonNode good = ResourceUtils.loadResource("/test.json");
//        final JsonNode bad = ResourceUtils.loadResource("/fstab-bad_test.json");
        final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

        final JsonSchema schema = factory.getJsonSchema(fstabSchema);

        ProcessingReport report;

        report = schema.validate(good);
        System.out.println(report);

//        report = schema.validate(bad);
//        System.out.println(report);

    }
}

