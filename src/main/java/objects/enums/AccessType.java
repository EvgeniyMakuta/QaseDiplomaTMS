package objects.enums;

import com.google.gson.annotations.SerializedName;

public enum AccessType {
    @SerializedName("private")
    PRIVATE,
    @SerializedName("public")
    PUBLIC;
}
