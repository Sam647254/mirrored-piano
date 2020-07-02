package ooo.trankvila;

import com.bitwig.extension.api.PlatformType;
import com.bitwig.extension.controller.AutoDetectionMidiPortNamesList;
import com.bitwig.extension.controller.ControllerExtensionDefinition;
import com.bitwig.extension.controller.api.ControllerHost;

import java.util.UUID;

public class MirroredPianoExtensionDefinition extends ControllerExtensionDefinition {
    private static final UUID DRIVER_ID = UUID.fromString("e8cee130-7574-43d3-81ee-39a1bb3ade0b");

    public MirroredPianoExtensionDefinition() {
    }

    @Override
    public String getName() {
        return "Mirrored Piano";
    }

    @Override
    public String getAuthor() {
        return "Sam Wang";
    }

    @Override
    public String getVersion() {
        return "0.1";
    }

    @Override
    public UUID getId() {
        return DRIVER_ID;
    }

    @Override
    public String getHardwareVendor() {
        return "5AM Works";
    }

    @Override
    public String getHardwareModel() {
        return "Mirrored Piano";
    }

    @Override
    public int getRequiredAPIVersion() {
        return 7;
    }

    @Override
    public int getNumMidiInPorts() {
        return 1;
    }

    @Override
    public int getNumMidiOutPorts() {
        return 0;
    }

    @Override
    public void listAutoDetectionMidiPortNames(final AutoDetectionMidiPortNamesList list, final PlatformType platformType) {
        if (platformType == PlatformType.WINDOWS) {
            // TODO: Set the correct names of the ports for auto detection on Windows platform here
            // and uncomment this when port names are correct.
            // list.add(new String[]{"Input Port 0"}, new String[]{"Output Port 0", "Output Port -1"});
        } else if (platformType == PlatformType.MAC) {
            // TODO: Set the correct names of the ports for auto detection on Windows platform here
            // and uncomment this when port names are correct.
            // list.add(new String[]{"Input Port 0"}, new String[]{"Output Port 0", "Output Port -1"});
        } else if (platformType == PlatformType.LINUX) {
            // TODO: Set the correct names of the ports for auto detection on Windows platform here
            // and uncomment this when port names are correct.
            // list.add(new String[]{"Input Port 0"}, new String[]{"Output Port 0", "Output Port -1"});
        }
    }

    @Override
    public MirroredPianoExtension createInstance(final ControllerHost host) {
        return new MirroredPianoExtension(this, host);
    }
}
