package com.example.demo;


public class VSPConstants {

	private VSPConstants() {
		throw new IllegalStateException("VSP Constant class");
	}

	public static final String MICROSPACE_POGSDATA = "v1/pogs/getPogsData";

	public static final String MACROSPACE_MASTER_PLANOGRAMS_DATA = "v1/floors/";

	public static final String MACROSPACE_RETRIEVE_STATUS = "v1/uploadStatus";

	public static final String MACROSPACE_FIXTURES_V1 = "v1/fixtures/";

	public static final String FIXTURES_DIMENSIONS = "fixtureDimensions/";

	public static final String REQUEST_PARAM_INTERIOR = "?interior=";

	public static final String FIXTURES = "/fixtures";

	public static final String MACROSPACE_MERCAHNDISINGFIXTURESBYINSTANCE = "/merchandisingFixturesByInstance";

	public static final String MERCHANDISING_FIXTURES = "/merchandisingFixtures";

	public static final String NON_MERCHANDISING_FIXTURES = "/nonMerchandisingFixtures";

	public static final String MACROSPACE_GETFIXTURES_NONMERCH_DATA = "v1/fixtures/nonmerchandising/";

	public static final String MACROSPACE_GETLOCATIONS_DATA = "v1/locations/";

	public static final String MASTER_PLANOGRAMS = "masterPlanograms";

	public static final String PLANOGRAMID = "v1/pogs/getPlanogramId/";

	public static final String GETTASKDETAILSBYID_ENDPOINT = "/workflowapi/task?taskId=";

	public static final String GETLOGINDETAILS_ENDPOINT = "/workflowapi/user/details?userId=";

	public static final String GETLISTOFTASK_ENDPOINT = "/workflowapi/task/list?isTenant=";

	public static final String CREATE_ENDPOINT = "/workflowapi/task";

	public static final String GETLOCATION_ENDPOINT = "/getLocations";

	public static final String MICROSPACE_STPDATA = "v1/locations/getSTPData";

	public static final String LABELS = "labels";

	public static final String MERCH = "merch";

	public static final String NONMERCH = "nonmerch";

	public static final String GETRESET_ENDPOINT = "/resets";

	public static final String MULTI_POG_YES = "Yes";

	public static final String MULTI_POG_NO = "No";

	public static final String GETLOCATIONRESET_ENDPOINT="/location/resets";

	public static final Integer POGMASTER_STATUSID = 7;

    public static final String MACROSPACE_ADD_FIXTURES = "addFixture";
    
    public static final String COMPLETED = "COMPLETED";
    
    public static final String PARTIALLY_COMPLETED = "PARTIALLY_COMPLETED";
    
    public static final String FAILED = "FAILED";

	public static final String FOOTPRINT = "/footprint";

	public static final String DESC = "desc";

	public static final Integer MPOG_LIMIT = 1000;

	public static final Integer OFFSET = 0;

	public static final String CONTENT_TYPE_MSEXCEL = "application/ms-excel";

	public static final String CONTENT_DISPOSITION = "Content-Disposition";

	public static final String FILENAME = "attachment; filename=";

	public static final String MPOG_BY_BAY_AND_STORE = "mpogByBayAndStore";

	public static final String REQUEST_PARAM_RESET_IDS = "?reset_ids=";

	public static final String REQUEST_PARAM_MASTER_PLANOGRAM_IDS = "&master_planogram_id=";

	public static final String RESETIDS = "reset_Ids";

	public static final String MASTER_PLANOGRAM_IDS = "master_planogram_ids";

	public static final String EXCEPTION = "Exception {}";

	public static final String UNDER_SCORE = "_";

	public static final String BASE_PROJECT = "RESET001";

	public static final String PRE_COUNT = "PRECOUNT";

	public static final String POST_COUNT = "POSTCOUNT";
	
	public static final String PRE = "Pre";
	
	public static final String POST = "Post";

	public static final String GET_DEPARTMENTS = "v1/departments";

	public static final String GET_PROJECT_DEPARTMENTS = "/sellingDepartments";

	public static final String TEST_WORKFLOW_REQUEST = "workflow";

	public static final String ADJACENCT_MASTER_PLANOGRAMS = "/getAdjacentPlanograms";

	public static final String EDITFIXTURE_OVERWRITE_MODE = "overwrite";

	public static final String NEW_LINE = System.getProperty("line.separator");

	public static final String CATEGORY_ADJACENCY = "category-adjacency";

	public static final String SPACE = " ";

	
	public static final String RESET_ID = "RESET_ID";
	public static final String INSTANCE_ID = "INSTANCE_ID";
	public static final String AILE = "AILE";
	public static final String POG_FLOW_BAY = "POG_FLOW_BAY";
	public static final String MPOG_ID = "MPOG_ID";
	
	public static final String MPOG_NAME = "MPOG_NAME";
	public static final String FIXTURE_HWD = "FIXTURE_HWD";
	public static final String MULTIPROGRAM = "MULTIPROGRAM";
	public static final String MPOG_FUTURE = "MPOG_FUTURE";
	
	public static final String POG_FLOW_FUTURE = "POG_FLOW_FUTURE";



}
