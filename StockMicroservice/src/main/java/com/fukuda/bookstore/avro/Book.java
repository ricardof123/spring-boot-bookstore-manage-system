/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.fukuda.bookstore.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Book extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 3676879068297246427L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Book\",\"namespace\":\"com.fukuda.bookstore.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Book> ENCODER =
      new BinaryMessageEncoder<Book>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Book> DECODER =
      new BinaryMessageDecoder<Book>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Book> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Book> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Book>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Book to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Book from a ByteBuffer. */
  public static Book fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public int id;
  @Deprecated public java.lang.String name;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Book() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name The new value for name
   */
  public Book(java.lang.Integer id, java.lang.String name) {
    this.id = id;
    this.name = name;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Integer)value$; break;
    case 1: name = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.Integer getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Integer value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Creates a new Book RecordBuilder.
   * @return A new Book RecordBuilder
   */
  public static com.fukuda.bookstore.avro.Book.Builder newBuilder() {
    return new com.fukuda.bookstore.avro.Book.Builder();
  }

  /**
   * Creates a new Book RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Book RecordBuilder
   */
  public static com.fukuda.bookstore.avro.Book.Builder newBuilder(com.fukuda.bookstore.avro.Book.Builder other) {
    return new com.fukuda.bookstore.avro.Book.Builder(other);
  }

  /**
   * Creates a new Book RecordBuilder by copying an existing Book instance.
   * @param other The existing instance to copy.
   * @return A new Book RecordBuilder
   */
  public static com.fukuda.bookstore.avro.Book.Builder newBuilder(com.fukuda.bookstore.avro.Book other) {
    return new com.fukuda.bookstore.avro.Book.Builder(other);
  }

  /**
   * RecordBuilder for Book instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Book>
    implements org.apache.avro.data.RecordBuilder<Book> {

    private int id;
    private java.lang.String name;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.fukuda.bookstore.avro.Book.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Book instance
     * @param other The existing instance to copy.
     */
    private Builder(com.fukuda.bookstore.avro.Book other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.Integer getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.fukuda.bookstore.avro.Book.Builder setId(int value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.fukuda.bookstore.avro.Book.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.fukuda.bookstore.avro.Book.Builder setName(java.lang.String value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.fukuda.bookstore.avro.Book.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Book build() {
      try {
        Book record = new Book();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Integer) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.String) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Book>
    WRITER$ = (org.apache.avro.io.DatumWriter<Book>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Book>
    READER$ = (org.apache.avro.io.DatumReader<Book>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}