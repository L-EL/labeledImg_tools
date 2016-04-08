
import ij.*;
import ij.IJ;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.tool.PlugInTool;
import java.awt.event.*;
import java.util.*;
//import inra.ijpb.data.image.Images3D;
//import javax.swing.JOptionPane; 
import ij.process.ImageProcessor;
//import org.scijava.util.LineOutputStream;
import ij.io.LogStream;

// developed by Elise Laruelle 
public class extract_labels_Tool extends PlugInTool {
	
	java.util.List<Float> list_value = new ArrayList<Float>();
	int nb_save = -1 ;	
	
	public void run(String arg) {
		Toolbar.addPlugInTool(this);
	}
	
	public void mouseClicked(ImagePlus imp,MouseEvent e) {
		 IJ.log(e.getMouseModifiersText(e.getModifiers()));
        //IJ.log(java.lang.Boolean.toString(a));
        IJ.log(String.valueOf(e.getModifiers()));
		ij.io.LogStream.redirectSystem(true); 
	    if(e.getModifiers() == 18 || e.getModifiers() == 20){
	    	System.out.println(list_value);
			//ImageProcessor img = imp.getProcessor();
			ImageStack img = imp.getStack();
			int width = img.getWidth();
			int height = img.getHeight();
			int nSlices = img.getSize();
			int bitDepth = img.getBitDepth() ;
			
			ImagePlus imp_saving_label = IJ.createImage("selected labels", width, height, nSlices, bitDepth) ;
			imp_saving_label.setCalibration( imp.getCalibration() );
			ImageStack img_saving_label = imp_saving_label.getStack();

			// image "inverse"
			ImagePlus imp_non_saving_label = IJ.createImage("non selected labels", width, height, nSlices, bitDepth) ;
			imp_non_saving_label.setCalibration( imp.getCalibration() );
			ImageStack img_non_saving_label = imp_non_saving_label.getStack();

			
	  	 	 for(int z = 0; z < nSlices; z++){  	 	 	
	  	 	 	for (int y = 0; y <height; y++){
	  	 	 		for (int x = 0; x < width; x++){
	  	 	 			int Flag_In = 0 ;
	  	 	 			
	  	 	 			for (int i =0 ; i<= nb_save;i++){
	  	 	 				if (img.getVoxel(x, y, z) == list_value.get(i)){
	  	 	 					img_saving_label.setVoxel(x, y, z, list_value.get(i));	  	 	 					
								Flag_In = 1 ; 
	  	 	 					}
	  	 	 				}
	  	 	 			if(Flag_In == 0){
	  	 	 				img_non_saving_label.setVoxel(x, y, z, img.getVoxel(x, y, z));
	  	 	 				}
	  	 	 			}
	  	 	 		}
	  	 	 	}
	  	 	 imp_saving_label.show();	
	  	 	 imp_non_saving_label.show();	
	  	 	 // reinitialize
	  	 	 list_value = new ArrayList<Float>();
	  	 	 nb_save = -1 ;
	  	 	}
	    else if(e.getClickCount() == 1) {
	    	nb_save +=1;
	    	ImageProcessor img = imp.getProcessor();
	    	list_value.add(img.getf(imp.getWindow().getCanvas().offScreenX(e.getX()),imp.getWindow().getCanvas().offScreenY(e.getY())));
	    	IJ.log("You save the label "+list_value.get(nb_save)+"");
	    	IJ.log("x : "+imp.getWindow().getCanvas().offScreenX(e.getX())+" y : "+imp.getWindow().getCanvas().offScreenY(e.getY())+"");	    	
	    	
	    }
	    
   	 }

}
