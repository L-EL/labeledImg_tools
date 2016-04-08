# tools_for_labeled_images
Fiji plugins
 -----
 Installation : in Fiji repository, go to "plugins" directory and create a "Tools" directory (if absent)
  - Replace value tool : put the ReplaceValue_tool.class inside
  - extract labels : put the extract_labels_Tool.class inside
-----
Replace value tool : add an "R" tool on the Fiji interface (if full, found in ">>"). When selected, click on the selected label to erase it (replace the label value by zero)
extract labels : add an "e" tool on the Fiji interface (if full, found in ">>"). When selected, click to selected labels to extract. Ctrl+click to create 2 images : one with the selected labels, the second with the unselected labels
