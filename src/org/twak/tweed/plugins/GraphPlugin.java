package org.twak.tweed.plugins;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import org.twak.readTrace.MiniTransform;
import org.twak.tweed.Tweed;
import org.twak.tweed.TweedFrame;
import org.twak.tweed.TweedSettings;
import org.twak.tweed.gen.GISGen;
import org.twak.tweed.gen.GraphGen;
import org.twak.tweed.gen.LotInfoGen;
import org.twak.tweed.gen.MeshGen;
import org.twak.tweed.gen.MiniGen;
import org.twak.tweed.gen.PanoGen;
import org.twak.tweed.gen.skel.SkelGen;
import org.twak.tweed.tools.FacadeTool;
import org.twak.tweed.tools.HouseTool;
import org.twak.tweed.tools.MoveTool;
import org.twak.tweed.tools.SelectTool;
import org.twak.tweed.tools.Tool;
import org.twak.utils.Filez;
import org.twak.utils.ui.SimpleFileChooser;
import org.twak.utils.ui.SimplePopup2;

import com.google.common.io.Files;
import com.thoughtworks.xstream.XStream;

public class GraphPlugin implements TweedPlugin {

	/**
	 * Remember to add tweedstreets project to Debug Configurtions -> ClassPath -> User Entries -> Add Project
	 */
	
	@Override
	public void addTools( Tweed tweed, List<Tool> tools ) {}
	
	public void addToAddMenu(TweedFrame tf, SimplePopup2 sp ) {
		if ( tf.hasGIS() ) {
			
			sp.add( "+ graph", new Runnable() {
				@Override
				public void run() {
					new SimpleFileChooser( tf.frame, false, "Select GML file", new File( Tweed.JME ), "gml" ) {
						public void heresTheFile( File gml ) throws Throwable {
							tf.addGen( new GraphGen( tf.tweed.makeWorkspaceRelative( gml ), tf.tweed ), true );
						};
					};
				}
			} );
		}
	}
}
