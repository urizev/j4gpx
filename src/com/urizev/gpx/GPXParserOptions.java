package com.urizev.gpx;

public class
GPXParserOptions
{
	public final boolean	skipWaypoints ;
	public final boolean	skipRoutes ;
	public final boolean	skipTracks ;

	public static final GPXParserOptions PARSE_ALL		  = new GPXParserOptions( false, false, false ) ;
	public static final GPXParserOptions SKIP_WAYPOINTS = new GPXParserOptions( true , false, false ) ;
	public static final GPXParserOptions SKIP_ROUTES	  = new GPXParserOptions( false, true , false ) ;
	public static final GPXParserOptions SKIP_TRACKS	  = new GPXParserOptions( false, false, true  ) ;
	public static final GPXParserOptions ONLY_WAYPOINTS = new GPXParserOptions( false, true , true  ) ;
	public static final GPXParserOptions ONLY_ROUTES	  = new GPXParserOptions( true , false, true  ) ;
	public static final GPXParserOptions ONLY_TRACKS	  = new GPXParserOptions( true , true , false ) ;

	public
	GPXParserOptions( final boolean skipWaypoints, final boolean skipRoutes, final boolean skipTracks )
	{
		super( ) ;
		this.skipWaypoints = skipWaypoints ;
		this.skipRoutes    = skipRoutes ;
		this.skipTracks    = skipTracks ;
	}
}
