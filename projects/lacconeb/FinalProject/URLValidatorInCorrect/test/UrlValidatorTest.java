

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void testManualTest()
   {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        System.out.println("***** Manual Testing *****");
            
        System.out.println("***** PART 1 ******");

        System.out.println(urlVal.isValid("http://www.amazon.com"));
        System.out.println(urlVal.isValid("http://www.amazon.com:10000"));
        System.out.println(urlVal.isValid("http://www.amazon.com:20000"));
        System.out.println(urlVal.isValid("http://www.amazon.com:30000"));
        System.out.println(urlVal.isValid("http://www.amazon.com:40000"));
        System.out.println(urlVal.isValid("http://www.amazon.com:50000"));
        System.out.println(urlVal.isValid("http://www.amazon.com:60000"));
            
        System.out.println("***** PART 2 ******");

        System.out.println(urlVal.isValid("http://www.amazon.com:0"));
        System.out.println(urlVal.isValid("http://www.amazon.com:10"));
        System.out.println(urlVal.isValid("http://www.amazon.com:200"));
        System.out.println(urlVal.isValid("http://www.amazon.com:3000"));
        System.out.println(urlVal.isValid("http://www.amazon.com:65535"));
        System.out.println(urlVal.isValid("http://www.amazon.com:65536"));
        System.out.println(urlVal.isValid("http://www.amazon.com:70000"));
            
        System.out.println("***** PART 3 ******");

        System.out.println(urlVal.isValid("http://www.amazon.com:0"));
        System.out.println(urlVal.isValid("http://www.amazon.com:52"));
        System.out.println(urlVal.isValid("http://www.amazon.com:99"));
        System.out.println(urlVal.isValid("http://www.amazon.com:100"));
        System.out.println(urlVal.isValid("http://www.amazon.com:999"));
        System.out.println(urlVal.isValid("http://www.amazon.com:555"));
        System.out.println(urlVal.isValid("http://www.amazon.com:723"));

        System.out.println("***** PART 4 *****");
            
        System.out.println(urlVal.isValid("http://www.yahoo.com"));
        System.out.println(urlVal.isValid("http://www.yahoo.com/test1"));
  
   }
   
   public void testYourFirstPartition()
   { 
      
      System.out.println("Scheme Test\n");
      
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - www.google.com");
         assertTrue(urlVal.isValid("www.google.com"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - ftp://www.google.com");
         assertTrue(urlVal.isValid("ftp://www.google.com"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://www.google.com");
         assertTrue(urlVal.isValid("http://www.google.com"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Fail
      try {
         System.out.println("Testing - htt://www.google.com");
         assertTrue(urlVal.isValid("htt://www.google.com"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      System.out.println("\n****************************");
   }
   
   public void testYourSecondPartition()
   {
   
      System.out.println("Authority Test\n");
      
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://google.com");
         assertTrue(urlVal.isValid("http://google.com"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://www.0.0.0.0.com");
         assertTrue(urlVal.isValid("http://www.0.0.0.0.com"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Fail
      try {
         System.out.println("Testing - http://256.256.256.256.com");
         assertTrue(urlVal.isValid("http://256.256.256.256.com"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://255.255.255.255.com");
         assertTrue(urlVal.isValid("http://255.255.255.255.com"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Fail
      try {
         System.out.println("Testing - http://900.6.789.255.com");
         assertTrue(urlVal.isValid("http://900.6.789.255.com"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      System.out.println("\n****************************");

   }
   
   public void testYourThirdPartition()
   {
      
      System.out.println("Port Test\n");
      
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://www.google.com:80");
         assertTrue(urlVal.isValid("http://www.google.com:80"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://www.google.com:3500");
         assertTrue(urlVal.isValid("http://www.google.com:3500"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://www.google.com:65535");
         assertTrue(urlVal.isValid("http://www.google.com:65535"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: fail
      try {
         System.out.println("Testing - http://www.google.com:65636");
         assertTrue(urlVal.isValid("http://www.google.com:65636"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
    //Expected Result: fail
      try {
         System.out.println("Testing - http://www.google.com:-1");
         assertTrue(urlVal.isValid("http://www.google.com:-1"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }

      System.out.println("\n****************************");
   }
   
   public void testYourFourthPartition()
   {
      
      System.out.println("Path Test\n");
      
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://www.google.com/test");
         assertTrue(urlVal.isValid("http://www.google.com/test"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://www.google.com/test/file");
         assertTrue(urlVal.isValid("http://www.google.com/test/file"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://www.google.com/test/");
         assertTrue(urlVal.isValid("http://www.google.com/test/"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://www.google.com/test//file");
         assertTrue(urlVal.isValid("http://www.google.com/test//file"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: fail
      try {
         System.out.println("Testing - http://www.google.com/..");
         assertTrue(urlVal.isValid("http://www.google.com/.."));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      System.out.println("\n****************************");
   }
   
   public void testYourFifthPartition()
   {
   
      System.out.println("Query Test\n");
      
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://www.google.com?action=view");
         assertTrue(urlVal.isValid("http://www.google.com?action=view"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Pass
      try {
         System.out.println("Testing - http://www.google.com?action=edit&mode=up");
         assertTrue(urlVal.isValid("http://www.google.com?action=edit&mode=up"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Fail
      try {
         System.out.println("Testing - http://www.google.comaction=view");
         assertTrue(urlVal.isValid("http://www.google.comaction=view"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      //Expected Result: Fail
      try {
         System.out.println("Testing - http://www.google.com????????????");
         assertTrue(urlVal.isValid("http://www.google.com????????????"));
         System.out.println("Passed");
      } catch (Error err) {
         System.out.println("Failed");
      }
      
      System.out.println("\n****************************");

   }
   
    // Total 21600
   public void testIsValidAllSchemes()
   {
	   System.out.println("Starting testIsValidAllSchemes...");
	   String testURL;	//Used to hold the permutated URL
	   int numValid = 0, numInvalid = 0;
	   int NUM_SCHEMES = 5;
	   int NUM_AUTHS = 10;
	   int NUM_PORTS = 6;
	   int NUM_PATHS = 12;
	   int NUM_QUERIES = 6;
	   
	   String schemes[] = new String [NUM_SCHEMES];
	   schemes[0] = "http://";		// Valid
	   schemes[1] = "ftp://";		// Valid
	   schemes[2] = "http:/";		// Invalid
	   schemes[3] = "localhost:";	// Invalid
	   schemes[4] = "fsociety";		// Invalid
	   
	   String authority[] = new String [NUM_AUTHS];
	   authority[0] = "www.amazon.com";	// Valid
	   authority[1] = "amazon.com";		// Valid
	   authority[2] = "255.255.255.255";// Valid
	   authority[3] = "abcdef";			// Invalid
	   authority[4] = "12345";			// Invalid
	   authority[5] = "abc.d1f";		// Invalid
	   authority[6] = ".abc";			// Invalid
	   authority[7] = "123.";			// Invalid
	   authority[8] = "abc.d1f";		// Invalid
	   authority[9] = "";				// Invalid
	   
	   String port[] = new String [NUM_PORTS];
	   port[0] = ":0";		// Valid
	   port[1] = ":8080";	// Valid
	   port[2] = "";		// Valid
	   port[3] = "port";	// Invalid
	   port[4] = "#";		// Invalid
	   port[5] = ":-8080";	// Invalid
	   
	   String path[] = new String [NUM_PATHS];
	   path[0] = "/taco";			// Valid
	   path[1] = "";				// Valid
	   path[2] = "plus+path";		// Valid
	   path[3] = "underscore_path";	// Valid
	   path[4] = "at@path";			// Valid
	   path[5] = "dot.path";		// Valid
	   path[6] = "percent%path";	// Valid	
	   path[7] = "forslash/path";	// Invalid
	   path[8] = "tilda~path";		// Invalid
	   path[9] = "colon:path";		// Invalid	
	   path[10] = "//";				// Invalid
	   path[11] = "/double//path";	// Invalid
	   
	   String query[] = new String [NUM_QUERIES];
	   query[0] = "";							// Valid
	   query[1] = "?phrasing=Lana";				// Valid
	   query[2] = "?12345";						// Valid
	   query[3] = "?rick=sanchez&morty=gazorp"; // Valid
	   query[4] = "/";							// Invalid
	   query[5] = "phrasing";					// Invalid
	   
	   UrlValidator urlVal = new UrlValidator(schemes, null, UrlValidator.ALLOW_ALL_SCHEMES);

	   System.out.println("GOOGLE CHECK " + urlVal.isValid("http://www.google.com"));
	   
	   for(int a = 0; a < NUM_SCHEMES; a++) {
		   for(int b = 0; b < NUM_AUTHS; b++) {
			   for(int c = 0; c < NUM_PORTS; c++) {
				   for(int d = 0; d < NUM_PATHS; d++) {
					   for(int e = 0; e < NUM_QUERIES; e++) {
						   testURL = schemes[a] + authority[b] + port[c] + path[d] + query[e];
						   if(urlVal.isValid(testURL)){
						   System.out.println(testURL + " is valid!");
							   numValid++;
						   } else {
						   System.out.println(testURL + " is NOT valid!");
							   numInvalid++;
						   }
					   }
				   }
			   }
		   }
	   } // for
	   System.out.println("Total VALID: " + numValid);
	   System.out.println("Total NOT VALID: " + numInvalid);
   } // testIsValidAllSchemes()
   
   // Total 51840 tests
   public void testIsValid2Slashes()
   {
	   System.out.println("Starting testIsValid2Slashes...");
	   String testURL;	//Used to hold the permutated URL
	   int numValid = 0, numInvalid = 0;
	   int NUM_SCHEMES = 12;
	   int NUM_AUTHS = 10;
	   int NUM_PORTS = 6;
	   int NUM_PATHS = 12;
	   int NUM_QUERIES = 6;
	   
	   String schemes[] = new String [NUM_SCHEMES];
	   schemes[0] = "http://";		// Valid
	   schemes[1] = "ftp://";		// Valid
	   schemes[2] = "https://";		// Valid
	   schemes[3] = "file://";		// Valid
	   schemes[4] = "fsociety";		// Invalid
	   schemes[5] = "http:/";		// Invalid
	   
	   /*Added these cases since EVERY Test was failing*/
	   schemes[6] = "";				// Invalid
	   schemes[7] = "123";			// Invalid
	   schemes[8] = "C://";			// Invalid
	   schemes[9] = "file:/";		// Invalid
	   schemes[10] = "FILE://";		// Invalid
	   schemes[11] = "HTTP://";		// Invalid
	   
	   String authority[] = new String [NUM_AUTHS];
	   authority[0] = "www.google.com";	// Valid
	   authority[1] = "google.com";		// Valid
	   authority[2] = "255.255.255.255";// Valid
	   authority[3] = "abcdef";			// Invalid
	   authority[4] = "12345";			// Invalid
	   authority[5] = "abc.d1f";		// Invalid
	   authority[6] = ".abc";			// Invalid
	   authority[7] = "123.";			// Invalid
	   authority[8] = "abc.d1f";		// Invalid
	   authority[9] = "";				// Invalid
	   
	   String port[] = new String [NUM_PORTS];
	   port[0] = "";		// Valid
	   port[1] = ":8080";	// Valid
	   port[2] = ":0";		// Valid
	   port[3] = "port";	// Invalid
	   port[4] = "#";		// Invalid
	   port[5] = ":-8080";	// Invalid
	   
	   String path[] = new String [NUM_PATHS];
	   path[0] = "";				// Valid
	   path[1] = "/taco";			// Valid
	   path[2] = "plus+path";		// Valid
	   path[3] = "underscore_path";	// Valid
	   path[4] = "at@path";			// Valid
	   path[5] = "dot.path";		// Valid
	   path[6] = "percent%path";	// Valid
	   path[7] = "/double//path";	// Valid <-- Should be allowed in ALLOW_2_SLASHES
	   path[8] = "tilda~path";		// Invalid
	   path[9] = "colon:path";		// Invalid	
	   path[10] = "//";				// Invalid
	   path[11] = "forslash/path";	// Invalid 
	   
	   String query[] = new String [NUM_QUERIES];
	   query[0] = "";							// Valid
	   query[1] = "?action=bronson";			// Valid
	   query[2] = "?12345";						// Valid
	   query[3] = "?rick=sanchez&morty=gazorp"; // Valid
	   query[4] = "/";							// Invalid
	   query[5] = "phrasing";					// Invalid
	   
	   UrlValidator urlVal = new UrlValidator(schemes, null, UrlValidator.ALLOW_2_SLASHES);
	   
	   System.out.println("GOOGLE CHECK " + urlVal.isValid("http://www.google.com"));
	   
	   for(int a = 0; a < NUM_SCHEMES; a++) {
		   for(int b = 0; b < NUM_AUTHS; b++) {
			   for(int c = 0; c < NUM_PORTS; c++) {
				   for(int d = 0; d < NUM_PATHS; d++) {
					   for(int e = 0; e < NUM_QUERIES; e++) {
						   testURL = schemes[a] + authority[b] + port[c] + path[d] + query[e];
						   if(urlVal.isValid(testURL)){
							   System.out.println(testURL + " is valid!");
							   numValid++;
						   } else {
							   System.out.println(testURL + " is NOT valid!");
							   numInvalid++;
						   }
					   }
				   }
			   }
		   }
	   } // for
	   System.out.println("Total VALID: " + numValid);
	   System.out.println("Total NOT VALID: " + numInvalid);
   } // testIsValid2Slashes()
   
   // Total 51840 tests
   public void testIsValidNoFrag()
   {
	   System.out.println("Starting testIsValidNoFrag...");
	   String testURL;	//Used to hold the permutated URL
	   int numValid = 0, numInvalid = 0;
	   int NUM_SCHEMES = 12;
	   int NUM_AUTHS = 10;
	   int NUM_PORTS = 6;
	   int NUM_PATHS = 12;
	   int NUM_QUERIES = 6;
	   
	   String schemes[] = new String [NUM_SCHEMES];
	   schemes[0] = "http://";		// Valid
	   schemes[1] = "ftp://";		// Valid
	   schemes[2] = "https://";		// Valid
	   schemes[3] = "file://";		// Valid
	   schemes[4] = "fsociety";		// Invalid
	   schemes[5] = "http:/";		// Invalid
	   
	   /*Added these cases since EVERY Test was failing*/
	   schemes[6] = "";				// Invalid
	   schemes[7] = "123";			// Invalid
	   schemes[8] = "C://";			// Invalid
	   schemes[9] = "file:/";		// Invalid
	   schemes[10] = "FILE://";		// Invalid
	   schemes[11] = "HTTP://";		// Invalid
	   
	   String authority[] = new String [NUM_AUTHS];
	   authority[0] = "www.google.com";	// Valid
	   authority[1] = "google.com";		// Valid
	   authority[2] = "255.255.255.255";// Valid
	   authority[3] = "abcdef";			// Invalid
	   authority[4] = "12345";			// Invalid
	   authority[5] = "abc.d1f";		// Invalid
	   authority[6] = ".abc";			// Invalid
	   authority[7] = "123.";			// Invalid
	   authority[8] = "abc.d1f";		// Invalid
	   authority[9] = "";				// Invalid
	   
	   String port[] = new String [NUM_PORTS];
	   port[0] = "";		// Valid
	   port[1] = ":8080";	// Valid
	   port[2] = ":0";		// Valid
	   port[3] = "port";	// Invalid
	   port[4] = "#";		// Invalid
	   port[5] = ":-8080";	// Invalid
	   
	   String path[] = new String [NUM_PATHS];
	   path[0] = "";				// Valid
	   path[1] = "/taco";			// Valid
	   path[2] = "plus+path";		// Valid
	   path[3] = "underscore_path";	// Valid
	   path[4] = "at@path";			// Valid
	   path[5] = "dot.path";		// Valid
	   path[6] = "percent%path";	// Valid
	   path[7] = "/double//path";	// Valid <-- Should be allowed in ALLOW_2_SLASHES
	   path[8] = "tilda~path";		// Invalid
	   path[9] = "colon:path";		// Invalid	
	   path[10] = "//";				// Invalid
	   path[11] = "forslash/path";	// Invalid 
	   
	   String query[] = new String [NUM_QUERIES];
	   query[0] = "";							// Valid
	   query[1] = "?action=bronson";			// Valid
	   query[2] = "?12345";						// Valid
	   query[3] = "?rick=sanchez&morty=gazorp"; // Valid
	   query[4] = "/";							// Invalid
	   query[5] = "phrasing";					// Invalid
	   
	   UrlValidator urlVal = new UrlValidator(schemes, null, UrlValidator.NO_FRAGMENTS);
	   
	   System.out.println("GOOGLE CHECK " + urlVal.isValid("http://www.google.com"));
	   
	   for(int a = 0; a < NUM_SCHEMES; a++) {
		   for(int b = 0; b < NUM_AUTHS; b++) {
			   for(int c = 0; c < NUM_PORTS; c++) {
				   for(int d = 0; d < NUM_PATHS; d++) {
					   for(int e = 0; e < NUM_QUERIES; e++) {
						   testURL = schemes[a] + authority[b] + port[c] + path[d] + query[e];
						   if(urlVal.isValid(testURL)){
							   System.out.println(testURL + " is valid!");
							   numValid++;
						   } else {
							   System.out.println(testURL + " is NOT valid!");
							   numInvalid++;
						   }
					   }
				   }
			   }
		   }
	   } // for
	   System.out.println("Total VALID: " + numValid);
	   System.out.println("Total NOT VALID: " + numInvalid);
   } // testIsValidNoFrag()
   


}
