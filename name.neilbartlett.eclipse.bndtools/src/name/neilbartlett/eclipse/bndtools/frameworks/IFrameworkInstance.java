package name.neilbartlett.eclipse.bndtools.frameworks;

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;

public interface IFrameworkInstance {
	/**
	 * Check whether the instance is valid for the selected framework type.
	 * 
	 * @return An {@link IStatus} object, which should have a severity of
	 *         {@code OK} if this framework instance is valid.
	 */
	IStatus getStatus();

	/**
	 * Get logical installation path of this instance, which may be a directory
	 * containing the core runtime and other resources.
	 * 
	 * @return The installation path of the framework instance
	 */
	IPath getInstancePath();

	/**
	 * Get the display name of the instance.
	 * 
	 * @return The human-readable display name of the framework instance.
	 */
	String getDisplayString();

	/**
	 * Get the array of classpath entries that must be added to the project at
	 * compile and run time.
	 * 
	 * @return An array {@code IClasspathEntry} for the core framework.
	 */
	IClasspathEntry[] getClasspathEntries();

	/**
	 * Return an icon image representing this framework type or instance. The
	 * caller of this method shall be responsible for cleaning the image
	 * resources when finished.
	 * 
	 * @param device
	 *            The SWT device.
	 * @return A new icon image.
	 */
	Image createIcon(Device device);

	/**
	 * Return the ID of this framework.
	 * @return
	 */
	String getFrameworkId();
	
	/**
	 * Return whether this framework instance is launchable.
	 */
	boolean isLaunchable();
	
	/**
	 * Return the standard program arguments for launching this framework
	 * instance in the specified working directory. Non-launchable framework instances may return {@code null} from this method.
	 * 
	 * @param workingDir
	 *            The working directory in which to launch
	 * @return The standard program arguments, as a String, with multiple
	 *         arguments separated by whitespace.
	 */
	String getStandardProgramArguments(File workingDir);
	
	/**
	 * Return the standard program arguments for launching this framework
	 * instance in the specified working directory. Non-launchable framework instances may return {@code null} from this method.
	 * 
	 * @param workingDir
	 *            The working directory in which to launch
	 * @return The standard program arguments, as a String, with multiple
	 *         arguments separated by whitespace.
	 */
	String getStandardVMArguments(File workingDir);
}