// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package com.example.Data;

/**
 * Protobuf type {@code DataTracking}
 */
public  final class DataTracking extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:DataTracking)
    DataTrackingOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DataTracking.newBuilder() to construct.
  private DataTracking(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DataTracking() {
    version_ = "";
    name_ = "";
    timestamp_ = 0L;
    phoneId_ = "";
    lon_ = 0L;
    lat_ = 0L;
  }
public java.lang.String toString1() {
    return this.getVersion() + " ," +
            this.getName() + " ," +
            this.getTimestamp() + " ," +
            this.getPhoneId() + " ," +
            this.getLon() + " ," +
            this.getLat();

}
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DataTracking(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000001;
            version_ = bs;
            break;
          }
          case 18: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000002;
            name_ = bs;
            break;
          }
          case 25: {
            bitField0_ |= 0x00000004;
            timestamp_ = input.readFixed64();
            break;
          }
          case 34: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000008;
            phoneId_ = bs;
            break;
          }
          case 41: {
            bitField0_ |= 0x00000010;
            lon_ = input.readFixed64();
            break;
          }
          case 49: {
            bitField0_ |= 0x00000020;
            lat_ = input.readFixed64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.Data.DataTrackingClass.internal_static_DataTracking_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.Data.DataTrackingClass.internal_static_DataTracking_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.Data.DataTracking.class, com.example.Data.DataTracking.Builder.class);
  }

  private int bitField0_;
  public static final int VERSION_FIELD_NUMBER = 1;
  private volatile java.lang.Object version_;
  /**
   * <code>required string version = 1;</code>
   */
  public boolean hasVersion() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>required string version = 1;</code>
   */
  public java.lang.String getVersion() {
    java.lang.Object ref = version_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        version_ = s;
      }
      return s;
    }
  }
  /**
   * <code>required string version = 1;</code>
   */
  public com.google.protobuf.ByteString
      getVersionBytes() {
    java.lang.Object ref = version_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      version_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object name_;
  /**
   * <code>required string name = 2;</code>
   */
  public boolean hasName() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>required string name = 2;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        name_ = s;
      }
      return s;
    }
  }
  /**
   * <code>required string name = 2;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TIMESTAMP_FIELD_NUMBER = 3;
  private long timestamp_;
  /**
   * <code>required fixed64 timestamp = 3;</code>
   */
  public boolean hasTimestamp() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>required fixed64 timestamp = 3;</code>
   */
  public long getTimestamp() {
    return timestamp_;
  }

  public static final int PHONE_ID_FIELD_NUMBER = 4;
  private volatile java.lang.Object phoneId_;
  /**
   * <code>optional string phone_id = 4;</code>
   */
  public boolean hasPhoneId() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional string phone_id = 4;</code>
   */
  public java.lang.String getPhoneId() {
    java.lang.Object ref = phoneId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        phoneId_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string phone_id = 4;</code>
   */
  public com.google.protobuf.ByteString
      getPhoneIdBytes() {
    java.lang.Object ref = phoneId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      phoneId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LON_FIELD_NUMBER = 5;
  private long lon_;
  /**
   * <code>optional fixed64 lon = 5;</code>
   */
  public boolean hasLon() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <code>optional fixed64 lon = 5;</code>
   */
  public long getLon() {
    return lon_;
  }

  public static final int LAT_FIELD_NUMBER = 6;
  private long lat_;
  /**
   * <code>optional fixed64 lat = 6;</code>
   */
  public boolean hasLat() {
    return ((bitField0_ & 0x00000020) == 0x00000020);
  }
  /**
   * <code>optional fixed64 lat = 6;</code>
   */
  public long getLat() {
    return lat_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasVersion()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasName()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasTimestamp()) {
      memoizedIsInitialized = 0;
      return false;
    }
    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, version_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeFixed64(3, timestamp_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, phoneId_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeFixed64(5, lon_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      output.writeFixed64(6, lat_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, version_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFixed64Size(3, timestamp_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, phoneId_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFixed64Size(5, lon_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFixed64Size(6, lat_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.Data.DataTracking)) {
      return super.equals(obj);
    }
    com.example.Data.DataTracking other = (com.example.Data.DataTracking) obj;

    boolean result = true;
    result = result && (hasVersion() == other.hasVersion());
    if (hasVersion()) {
      result = result && getVersion()
          .equals(other.getVersion());
    }
    result = result && (hasName() == other.hasName());
    if (hasName()) {
      result = result && getName()
          .equals(other.getName());
    }
    result = result && (hasTimestamp() == other.hasTimestamp());
    if (hasTimestamp()) {
      result = result && (getTimestamp()
          == other.getTimestamp());
    }
    result = result && (hasPhoneId() == other.hasPhoneId());
    if (hasPhoneId()) {
      result = result && getPhoneId()
          .equals(other.getPhoneId());
    }
    result = result && (hasLon() == other.hasLon());
    if (hasLon()) {
      result = result && (getLon()
          == other.getLon());
    }
    result = result && (hasLat() == other.hasLat());
    if (hasLat()) {
      result = result && (getLat()
          == other.getLat());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasVersion()) {
      hash = (37 * hash) + VERSION_FIELD_NUMBER;
      hash = (53 * hash) + getVersion().hashCode();
    }
    if (hasName()) {
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
    }
    if (hasTimestamp()) {
      hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getTimestamp());
    }
    if (hasPhoneId()) {
      hash = (37 * hash) + PHONE_ID_FIELD_NUMBER;
      hash = (53 * hash) + getPhoneId().hashCode();
    }
    if (hasLon()) {
      hash = (37 * hash) + LON_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getLon());
    }
    if (hasLat()) {
      hash = (37 * hash) + LAT_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getLat());
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.Data.DataTracking parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.Data.DataTracking parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.Data.DataTracking parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.Data.DataTracking parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.Data.DataTracking parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.Data.DataTracking parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.Data.DataTracking parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.Data.DataTracking parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.Data.DataTracking parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.Data.DataTracking parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.Data.DataTracking parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.Data.DataTracking parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.Data.DataTracking prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code DataTracking}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:DataTracking)
      com.example.Data.DataTrackingOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.Data.DataTrackingClass.internal_static_DataTracking_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.Data.DataTrackingClass.internal_static_DataTracking_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.Data.DataTracking.class, com.example.Data.DataTracking.Builder.class);
    }

    // Construct using com.example.Data.DataTracking.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      version_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      name_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      timestamp_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000004);
      phoneId_ = "";
      bitField0_ = (bitField0_ & ~0x00000008);
      lon_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000010);
      lat_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000020);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.Data.DataTrackingClass.internal_static_DataTracking_descriptor;
    }

    @java.lang.Override
    public com.example.Data.DataTracking getDefaultInstanceForType() {
      return com.example.Data.DataTracking.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.Data.DataTracking build() {
      com.example.Data.DataTracking result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.Data.DataTracking buildPartial() {
      com.example.Data.DataTracking result = new com.example.Data.DataTracking(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.version_ = version_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.name_ = name_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.timestamp_ = timestamp_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.phoneId_ = phoneId_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.lon_ = lon_;
      if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
        to_bitField0_ |= 0x00000020;
      }
      result.lat_ = lat_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.Data.DataTracking) {
        return mergeFrom((com.example.Data.DataTracking)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.Data.DataTracking other) {
      if (other == com.example.Data.DataTracking.getDefaultInstance()) return this;
      if (other.hasVersion()) {
        bitField0_ |= 0x00000001;
        version_ = other.version_;
        onChanged();
      }
      if (other.hasName()) {
        bitField0_ |= 0x00000002;
        name_ = other.name_;
        onChanged();
      }
      if (other.hasTimestamp()) {
        setTimestamp(other.getTimestamp());
      }
      if (other.hasPhoneId()) {
        bitField0_ |= 0x00000008;
        phoneId_ = other.phoneId_;
        onChanged();
      }
      if (other.hasLon()) {
        setLon(other.getLon());
      }
      if (other.hasLat()) {
        setLat(other.getLat());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (!hasVersion()) {
        return false;
      }
      if (!hasName()) {
        return false;
      }
      if (!hasTimestamp()) {
        return false;
      }
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.example.Data.DataTracking parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.Data.DataTracking) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object version_ = "";
    /**
     * <code>required string version = 1;</code>
     */
    public boolean hasVersion() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string version = 1;</code>
     */
    public java.lang.String getVersion() {
      java.lang.Object ref = version_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          version_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>required string version = 1;</code>
     */
    public com.google.protobuf.ByteString
        getVersionBytes() {
      java.lang.Object ref = version_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        version_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>required string version = 1;</code>
     */
    public Builder setVersion(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      version_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required string version = 1;</code>
     */
    public Builder clearVersion() {
      bitField0_ = (bitField0_ & ~0x00000001);
      version_ = getDefaultInstance().getVersion();
      onChanged();
      return this;
    }
    /**
     * <code>required string version = 1;</code>
     */
    public Builder setVersionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      version_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <code>required string name = 2;</code>
     */
    public boolean hasName() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string name = 2;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          name_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>required string name = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>required string name = 2;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required string name = 2;</code>
     */
    public Builder clearName() {
      bitField0_ = (bitField0_ & ~0x00000002);
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>required string name = 2;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      name_ = value;
      onChanged();
      return this;
    }

    private long timestamp_ ;
    /**
     * <code>required fixed64 timestamp = 3;</code>
     */
    public boolean hasTimestamp() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required fixed64 timestamp = 3;</code>
     */
    public long getTimestamp() {
      return timestamp_;
    }
    /**
     * <code>required fixed64 timestamp = 3;</code>
     */
    public Builder setTimestamp(long value) {
      bitField0_ |= 0x00000004;
      timestamp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required fixed64 timestamp = 3;</code>
     */
    public Builder clearTimestamp() {
      bitField0_ = (bitField0_ & ~0x00000004);
      timestamp_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object phoneId_ = "";
    /**
     * <code>optional string phone_id = 4;</code>
     */
    public boolean hasPhoneId() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional string phone_id = 4;</code>
     */
    public java.lang.String getPhoneId() {
      java.lang.Object ref = phoneId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          phoneId_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string phone_id = 4;</code>
     */
    public com.google.protobuf.ByteString
        getPhoneIdBytes() {
      java.lang.Object ref = phoneId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        phoneId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string phone_id = 4;</code>
     */
    public Builder setPhoneId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
      phoneId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string phone_id = 4;</code>
     */
    public Builder clearPhoneId() {
      bitField0_ = (bitField0_ & ~0x00000008);
      phoneId_ = getDefaultInstance().getPhoneId();
      onChanged();
      return this;
    }
    /**
     * <code>optional string phone_id = 4;</code>
     */
    public Builder setPhoneIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
      phoneId_ = value;
      onChanged();
      return this;
    }

    private long lon_ ;
    /**
     * <code>optional fixed64 lon = 5;</code>
     */
    public boolean hasLon() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional fixed64 lon = 5;</code>
     */
    public long getLon() {
      return lon_;
    }
    /**
     * <code>optional fixed64 lon = 5;</code>
     */
    public Builder setLon(long value) {
      bitField0_ |= 0x00000010;
      lon_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional fixed64 lon = 5;</code>
     */
    public Builder clearLon() {
      bitField0_ = (bitField0_ & ~0x00000010);
      lon_ = 0L;
      onChanged();
      return this;
    }

    private long lat_ ;
    /**
     * <code>optional fixed64 lat = 6;</code>
     */
    public boolean hasLat() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>optional fixed64 lat = 6;</code>
     */
    public long getLat() {
      return lat_;
    }
    /**
     * <code>optional fixed64 lat = 6;</code>
     */
    public Builder setLat(long value) {
      bitField0_ |= 0x00000020;
      lat_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional fixed64 lat = 6;</code>
     */
    public Builder clearLat() {
      bitField0_ = (bitField0_ & ~0x00000020);
      lat_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:DataTracking)
  }

  // @@protoc_insertion_point(class_scope:DataTracking)
  private static final com.example.Data.DataTracking DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.Data.DataTracking();
  }

  public static com.example.Data.DataTracking getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<DataTracking>
      PARSER = new com.google.protobuf.AbstractParser<DataTracking>() {
    @java.lang.Override
    public DataTracking parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DataTracking(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DataTracking> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DataTracking> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.Data.DataTracking getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

