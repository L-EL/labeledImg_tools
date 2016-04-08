# tools_for_labeled_images
Fiji plugins
 Installation :in fiji repository go to "plugins" directory and create a "Tools" directory if abscents
  - Replace value tool : put the ReplaceValue_tool.class inside
  - extract labels : put the extract_labels_Tool.class inside
Replace value tool : add a "R" tool on the Fiji interface (if full, found in ">>"). When selected, click on the selected label to errase it (replace the label value by zero)
extract labels : add a "e" tool on the Fiji interface (if full, found in ">>"). When selected, click to select labels to extract. Ctrl+click to create 2 images : one with the selected labels, the second with the unselected labels
