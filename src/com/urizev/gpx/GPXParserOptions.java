package org.alternativevision.gpx;

public
class
GPXParserOptions
{
	public final boolean	skipWaypoints ;
	public final boolean	skipRoutes ;
	public final boolean	skipTracks ;

	public static final GPXParserOptions PARSE_ALL		= new GPXParserOptions( false, false, false ) ;
	public static final GPXParserOptions SKIP_WAYPOINTS = new GPXParserOptions( true, false, false ) ;
	public static final GPXParserOptions SKIP_ROUTES	= new GPXParserOptions( false, true, false ) ;
	public static final GPXParserOptions SKIP_TRACKS	= new GPXParserOptions( false, false, true ) ;

	public
	GPXParserOptions( final boolean skipWaypoints, final boolean skipRoutes, final boolean skipTracks )
	{
		super( ) ;
		this.skipWaypoints = skipWaypoints ;
		this.skipRoutes    = skipRoutes ;
		this.skipTracks    = skipTracks ;
	}
}
