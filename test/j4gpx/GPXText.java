package j4gpx;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.urizev.gpx.GPXParser;
import com.urizev.gpx.beans.GPX;
import com.urizev.gpx.beans.Route;
import com.urizev.gpx.beans.Track;
import com.urizev.gpx.beans.Waypoint;

public class GPXText {
	private static GPXParser parser;

	@BeforeClass
	public static void setUpBeforeClass() {
		parser = new GPXParser();
	}

	@Test
	public void testTwoSegments() {
		try {
			GPX gpx = parser.parseGPX(new FileInputStream("test/gpx/two-segments.gpx"));
			assertEquals(0, gpx.getWaypoints().size());
			
			Set<Track> tracks = gpx.getTracks();
			assertEquals(1, tracks.size());
			
			Track track = tracks.iterator().next();
			ArrayList<Waypoint> points = track.getTrackPoints();
			assertEquals(3, points.size());
			
			ArrayList<ArrayList<Waypoint>> segments = track.getTrackSegments();
			assertEquals(2, segments.size());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testOnlyWayPoints() {
		try {
			GPX gpx = parser.parseGPX(new FileInputStream("test/gpx/only-wp.gpx"));
			
			Set<Track> tracks = gpx.getTracks();
			assertEquals(0, tracks.size());
			
			assertEquals(4, gpx.getWaypoints().size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void textSimpleRoute() {
		try {
			GPX gpx = parser.parseGPX(new FileInputStream("test/gpx/simple-route.gpx"));
			
			assertEquals(0, gpx.getWaypoints().size());
			
			Set<Track> tracks = gpx.getTracks();
			assertEquals(0, tracks.size());
			
			Set<Route> routes = gpx.getRoutes();
			assertEquals(1, routes.size());
			
			assertEquals(4, routes.iterator().next().getRoutePoints().size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void textSimpleTrack() {
		try {
			GPX gpx = parser.parseGPX(new FileInputStream("test/gpx/simple-track.gpx"));
			
			assertEquals(0, gpx.getWaypoints().size());
			
			Set<Track> tracks = gpx.getTracks();
			assertEquals(1, tracks.size());
			assertEquals(4, tracks.iterator().next().getTrackPoints().size());

			Set<Route> routes = gpx.getRoutes();
			assertEquals(0, routes.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void textSimpleTrackGarminEtrex() {
		try {
			GPX gpx = parser.parseGPX(new FileInputStream("test/gpx/simple-track-garmin-etrex.gpx"));
			
			assertEquals(0, gpx.getWaypoints().size());
			
			Set<Track> tracks = gpx.getTracks();
			assertEquals(1, tracks.size());
			assertEquals(4, tracks.iterator().next().getTrackPoints().size());
			assertEquals(1, tracks.iterator().next().getTrackSegments().size());

			Set<Route> routes = gpx.getRoutes();
			assertEquals(0, routes.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
