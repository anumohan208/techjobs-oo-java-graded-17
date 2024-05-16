package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", job.getName());

        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());

        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());

        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());

        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobString = job.toString();
        assertTrue(jobString.startsWith("\n"));
        assertTrue(jobString.endsWith("\n"));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobString = job.toString();

        assertTrue(jobString.contains("ID: " + job.getId()));
        assertTrue(jobString.contains("Name: " + job.getName()));
        assertTrue(jobString.contains("Employer: " + job.getEmployer().getValue()));
        assertTrue(jobString.contains("Location: " + job.getLocation().getValue()));
        assertTrue(jobString.contains("Position Type: " + job.getPositionType().getValue()));
        assertTrue(jobString.contains("Core Competency: " + job.getCoreCompetency().getValue()));
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("QA", null, null, null, null);

        String jobString = job.toString();
        System.out.println(jobString);
        assertTrue(jobString.contains("ID: " + job.getId()));
        assertTrue(jobString.contains("Name: QA"));
        assertTrue(jobString.contains("Employer: Data not available"));
        assertTrue(jobString.contains("Location: Data not available"));
        assertTrue(jobString.contains("Position Type: Data not available"));
        assertTrue(jobString.contains("Core Competency: Data not available"));
    }
}
