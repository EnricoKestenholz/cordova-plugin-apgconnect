In Android MainActivity

		import ch.apgsga.apgconnect.APGSDKManager;

        @Override
	    public void onCreate(Bundle savedInstanceState)
	    {
	       [....]
	           APGSDKManager.setup("AUTHTOKEN", getApplication());
	       [...]
	    }
