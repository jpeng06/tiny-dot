package cs.ubc.ca.analysis;

import cs.ubc.ca.errors.CompileException;
import cs.ubc.ca.dsl.DotProgram;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertNotNull;


public class MissingDeclarationTest {

    private DotProgram dotProgram;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
    }

    @Test
    public void analyzeValidInput() {
        this.dotProgram = new DotProgram("valid/input.tdot");
        this.dotProgram.parse();

        assertNotNull(this.dotProgram.getAst());
    }

    @Test
    public void analyzeMissingCircle() {
        expectedEx.expect(CompileException.class);
//        expectedEx.expectMessage("Unable to load source: input.tdot");
        this.dotProgram = new DotProgram("invalid/missing.circle.tdot");
        this.dotProgram.compile();
    }

    @Test
    public void analyzeMissingSquare() {
        expectedEx.expect(CompileException.class);
//        expectedEx.expectMessage("Unable to load source: input.tdot");
        this.dotProgram = new DotProgram("invalid/missing.square.tdot");
        this.dotProgram.compile();
    }
}